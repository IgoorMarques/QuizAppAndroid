package com.igor.appinovatec.controllers.AppRotas

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.igor.appinovatec.R
import com.igor.appinovatec.data.*
import com.igor.appinovatec.model.HomeContentItem
import com.igor.appinovatec.model.QuizQuestions
import com.igor.appinovatec.views.AppBars.BarItem
import com.igor.appinovatec.views.AppBars.ScaffolBottomBar
import com.igor.appinovatec.views.AppBars.ScaffolTopBar
import com.igor.appinovatec.views.AppScreens.*
import com.igor.appinovatec.views.conversaoXmlToCompose.TelaDeLogin
import com.igor.appinovatec.views.ui.theme.AppInovatecTheme
import com.igor.appinovatec.views.ui.theme.Teal200
import com.igor.appinovatec.views.ui.theme.backGround
import kotlinx.coroutines.delay

class rotas : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val currentBackStackEntryAsState = navController.currentBackStackEntryAsState()
            val currentDestination = currentBackStackEntryAsState.value?.destination

            AppInovatecTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val mostrarBars = remember {
                        val valor = currentDestination?.route == AppRotas.HOME_USER
                        mutableStateOf(valor)
                    }
                    Log.i("mostrarBar", "onCreate: ${mostrarBars.value}")

                    mostrarBars.value = ((currentDestination?.route == AppRotas.HOME_USER)
                        .or(currentDestination?.route == AppRotas.NOVO_QUIZ_SCREEN)
                        .or(currentDestination?.route == AppRotas.TELA_PERFIL_USER))


                    val selectedItem = remember(currentDestination) {
                        val item = currentDestination?.let { destination ->
                            bottomBarItens.find {
                                it.rota == destination.route
                            } ?: bottomBarItens.first()
                        }
                        mutableStateOf(item)
                    }

                    SkillsterApp(
                        showBars = mostrarBars.value,
                        bottomAppBarItemSelected = selectedItem,
                        onBottomAppBarItemSelectedChange = {
                            if (it.rota == AppRotas.SAIR_DO_APP) {
                                finish()
                            } else if (it.rota != currentDestination?.route) {
                                navController.navigate(it.rota)
                            }
                        }
                    )
                    {

                        AppNavigation(navController = navController)
                    }
                }
            }
        }
    }
}

var dadosMenuConcluidoItens = historicoQuiz

@SuppressLint("MutableCollectionMutableState")
@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppRotas.TELA_DE_CARREGAMENTO
    )
    {
        composable(AppRotas.HOME_USER) {
            val homeItemSelected = remember {
                val menuItem = menuMainScreenItens.first()
                mutableStateOf(menuItem)
            }
            val showAlertDialog = remember {
                val status = false
                mutableStateOf(status)
            }
            val contentItemSelected = remember {
                val contentItem: QuizQuestions? = null
                mutableStateOf(contentItem)
            }
            val dataContent = remember {
                val data = historicoQuiz
                mutableStateOf(data)
            }
            if (homeItemSelected.value.rota == AppRotas.HOME_PENDENTE) {
                dataContent.value = userQuizes
            } else if (homeItemSelected.value.rota == AppRotas.HOME_emAndamento) {
                dataContent.value = quizesRecebidos
            } else if (homeItemSelected.value.rota == AppRotas.HOME_HISTORICO) {
                dataContent.value = historicoQuiz
            }
            val itemSelecionado = remember {
                val item: QuizQuestions? = null
                mutableStateOf(item)
            }
            val mostrarTelaAviso = remember {
                mutableStateOf(false)
            }
            TelaPrincipal(menuItemSelected = homeItemSelected.value,
                onMenuItemSelectedChange = {
                    if (it.rota == AppRotas.HOME_emAndamento) {
                        homeItemSelected.value = it
                    } else if (it.rota == AppRotas.HOME_PENDENTE) {
                        homeItemSelected.value = it
                    } else if (it.rota == AppRotas.HOME_HISTORICO) {
                        homeItemSelected.value = it
                    }
                }
            ) {
                if (dataContent.value.isEmpty()) {
                    Box(
                        modifier = Modifier
                            .height(
                                300.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(Icons.Filled.Info, "status",
                            tint = Color.Yellow, modifier = Modifier.size(100.dp))
                            Text(text = "Não há quizzis por aqui")
                            Text(text = "Gerar novo quiz")
                            Icon(Icons.Rounded.Add, contentDescription = "NovoQuiz",
                                modifier = Modifier.clickable {
                                    navController.navigate(AppRotas.NOVO_QUIZ_SCREEN)
                                })
                        }

                    }
                } else {
                    dataContent.value.forEach { item ->
                        if (item.infoQuiz != null) {
                            TelaItem(item = item.infoQuiz, onClick = {
                                if (homeItemSelected.value.rota == AppRotas.HOME_HISTORICO) {
                                    navController.navigate("${AppRotas.TELA_RESULTADOS}/${item.id}")
                                } else {
                                    mostrarTelaAviso.value = true
                                    itemSelecionado.value = item
                                }
                            },
                                onDeleteClick = {
                                    showAlertDialog.value = true
                                    contentItemSelected.value = item
                                }
                            )
                        }
                    }
                }

                if (showAlertDialog.value.and(contentItemSelected.value != null)) {
                    ConfirmationDialog(message = "Tem certeza que deseja remover esse item?",
                        onDismiss = {
                            showAlertDialog.value = false
                        },
                        onConfirm = {
                            if (contentItemSelected.value?.infoQuiz?.rota == AppRotas.HOME_PENDENTE) {
                                userQuizes.remove(contentItemSelected.value)
                            } else if (contentItemSelected.value?.infoQuiz?.rota == AppRotas.HOME_emAndamento) {
                                quizesRecebidos.remove(contentItemSelected.value)
                            } else if (contentItemSelected.value?.infoQuiz?.rota == AppRotas.HOME_HISTORICO) {
                                historicoQuiz.remove(contentItemSelected.value)
                            }
                        }
                    )
                }
                if (mostrarTelaAviso.value) {
                    TelaDeAviso(onStartClick = {
                        if (itemSelecionado.value != null) {
                            navController.navigate("${AppRotas.QUIZ_QUESTIONS}/${itemSelecionado.value!!.id}")
                        }
                    },
                        onCloseClick = {
                            mostrarTelaAviso.value = false
                        }
                    )
                }
            }
        }
        composable(AppRotas.NOVO_QUIZ_SCREEN) {
            TelaAreas(onClick = {
                navController.navigate("${AppRotas.TELA_DE_CONFIGURACAO_QUIZ}/${it.id}")
            })
        }
        composable(AppRotas.TELA_PERFIL_USER) {
            TelaPerfilUser()
        }
        composable(AppRotas.TELA_DE_CARREGAMENTO) {
            TelaDeCarregamento()
            LaunchedEffect(key1 = Unit) {
                delay(1500)
                navController.navigate(AppRotas.TELA_DE_LOGIN)
            }
        }
        composable(AppRotas.TELA_DE_LOGIN) {
            TelaDeLogin() {
                navController.navigate(AppRotas.HOME_USER)
            }
        }
        composable("${AppRotas.QUIZ_QUESTIONS}/{id}") { navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getString("id")
            val quizAtual = quizes.firstOrNull { it.id == id }
            if (quizAtual != null) {
                val isCheckboxSelected = remember { mutableStateOf(false) }
                val tempo = remember {
                    val time = quizAtual.timePorQuestao.toLong()
                    mutableStateOf(time)
                }
                val podeResponder = remember { mutableStateOf(false) }

                LaunchedEffect(key1 = podeResponder.value) {
                    while ((tempo.value <= quizAtual.timePorQuestao).and(tempo.value >= 1)) {
                        delay(1000)
                        tempo.value -= 1
                    }
                }
                val questoes = quizAtual.questoes()
                if (questoes != null) {
                    val acertos = remember {
                        mutableStateOf(0)
                    }
                    val totalQuestoes = remember {
                        val valor = questoes.size
                        mutableStateOf(valor)
                    }
                    val questaoIndex = remember {
                        val index = 0
                        mutableStateOf(index)
                    }
                    val questaoAtual = remember(questaoIndex.value) {
                        val qAtual =
                            if (questaoIndex.value <= totalQuestoes.value - 1) questoes[questaoIndex.value]
                            else questoes[questaoIndex.value - 1]
                        mutableStateOf(qAtual)
                    }
                    val selectedOptions = remember {
                        val opcoes = Array(totalQuestoes.value) { "" }
                        mutableStateOf(opcoes)
                    }
                    val currentSelectedOption = remember {
                        mutableStateOf("")
                    }
                    if (tempo.value == 0L) {
                        podeResponder.value = false
                    } else if (tempo.value <= quizAtual.timePorQuestao) {
                        podeResponder.value = true
                    }

                    MultipleChoiceQuestion(
                        questao = questaoAtual.value,
                        questaoAtual = if (questaoIndex.value + 1 <= totalQuestoes.value) questaoIndex.value + 1
                        else totalQuestoes.value,
                        totalQuestoes = totalQuestoes.value,
                        tempoMax = quizAtual.timePorQuestao.toLong(),
                        tempoAtual = tempo.value,
                        opcaoSelecionada = currentSelectedOption.value,
                        checkBoxSelecionada = isCheckboxSelected.value,
                        quandoMarcadaOpcao = {
                            if ((tempo.value > 0)) {
                                isCheckboxSelected.value = !isCheckboxSelected.value
                                if (currentSelectedOption.value != it) {
                                    isCheckboxSelected.value = true
                                }
                                if (isCheckboxSelected.value) {
                                    currentSelectedOption.value = it
                                } else {
                                    currentSelectedOption.value = ""
                                }
                            } else if (tempo.value <= 0) {
                                isCheckboxSelected.value = false
                            }
                        },
                        btAvancar = {
                            if (questaoIndex.value <= (totalQuestoes.value - 1)) {
                                selectedOptions.value[questaoIndex.value] = ""
                                questaoIndex.value += 1
                                isCheckboxSelected.value = false
                                tempo.value = quizAtual.timePorQuestao.toLong()
                                currentSelectedOption.value = ""
                                podeResponder.value = true
                            }
                        },
                        btResponder = {
                            if (questaoIndex.value <= totalQuestoes.value - 1) {
                                selectedOptions.value[questaoIndex.value] =
                                    currentSelectedOption.value
                                if (currentSelectedOption.value == questaoAtual.value.alternativaCorreta) {
                                    acertos.value += 1
                                }
                                tempo.value = quizAtual.timePorQuestao.toLong()
                                isCheckboxSelected.value = false
                                questaoIndex.value += 1
                                currentSelectedOption.value = ""
                                podeResponder.value = true
                            }
                        },
                    ) {
                        if (questaoIndex.value >= totalQuestoes.value) {
                            LaunchedEffect(key1 = Unit){
                                historicoQuiz.add(
                                    QuizQuestions(
                                        id = quizAtual.id,
                                        assunto = quizAtual.assunto,
                                        qtdQuestoes = totalQuestoes.value,
                                        alternativasSelecionadas = selectedOptions.value,
                                        infoQuiz = HomeContentItem(
                                            id = quizAtual.id,
                                            title = "Concluído",
                                            assunto = quizAtual.assunto,
                                            quizTpo = "Resultado",
                                            quizStatus = "${acertos.value}/${totalQuestoes.value}",
                                            data = dataHoraAtual(),
                                            bt_action = "Detalhes"
                                        )
                                    )
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Teal200)
                            ) {

                            }
                            CustomDialog(btContinuar = {
                                navController.navigate(AppRotas.HOME_USER)
                            },
                                btQuestoes = {
                                    navController.navigate("${AppRotas.TELA_RESULTADOS}/${quizAtual.id}")
                                },
                                onDismiss = {})
                        }
                    }
                }
            }
        }
        composable("${AppRotas.TELA_DE_AVISO}/{id}") { infos ->
            val id = infos.arguments?.getString("id")
            val mostrarTelaDeAviso = remember {
                mutableStateOf(false)
            }

            TelaDeAviso(onStartClick = { navController.navigate(AppRotas.QUIZ_QUESTIONS) },
                onCloseClick = {
                    navController.navigate(AppRotas.HOME_USER)
                })
        }
        composable("${AppRotas.TELA_DE_CONFIGURACAO_QUIZ}/{areaId}") { navBackStackEntry ->
            val btNivelSelected = remember {
                val status = "junior"
                mutableStateOf(status)
            }
            val valorLinhaTempo = remember {
                mutableStateOf(160.3333f)
            }
            val valorLinha = remember {
                mutableStateOf(475f)
            }
            if (valorLinha.value < 475f) {
                valorLinha.value = 475f
            } else if (valorLinha.value > 950) {
                valorLinha.value = 950f
            }
            if (valorLinhaTempo.value < 160.33333f) {
                valorLinhaTempo.value = 160.33333f
            } else if (valorLinhaTempo.value > 950) {
                valorLinhaTempo.value = 950f
            }
            val meuModifer = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(if (valorLinha.value > 0) Color.Cyan else backGround)
                .pointerInput(Unit) {
                    detectDragGestures { _, dragAmount ->
                        if ((valorLinha.value >= 475f).and(valorLinha.value <= 950f)) {
                            valorLinha.value += dragAmount.x
                        } else {
                            if (dragAmount.x > 0f) {
                                valorLinha.value += dragAmount.x
                            }
                        }
                    }
                }
            val meuModiferTempo = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(if (valorLinhaTempo.value > 0) Color.Cyan else backGround)
                .pointerInput(Unit) {
                    detectDragGestures { _, dragAmount ->
                        if ((valorLinhaTempo.value >= 160.3333f).and(valorLinhaTempo.value <= 950f)) {
                            valorLinhaTempo.value += dragAmount.x
                        } else {
                            if (dragAmount.x > 0f) {
                                valorLinha.value += dragAmount.x
                            }
                        }
                    }
                }
            val id = navBackStackEntry.arguments?.getString("areaId")
            if (id != null) {
                val item = areasQuiz.find { it.id == id }
                if (item != null) {
                    TelaConfigQuiz(
                        itemQuiz = item,
                        modifier = meuModifer,
                        modifierTempo = meuModiferTempo,
                        valorLinha = valorLinha.value,
                        valorLinhaTempo = valorLinhaTempo.value,
                        selectedBtLevel = btNivelSelected.value,
                        btLevelJunior = { btNivelSelected.value = "junior" },
                        btLevelPleno = { btNivelSelected.value = "pleno" },
                        btLevelSenior = { btNivelSelected.value = "senior" },
                        btCancelar = { navController.navigate(AppRotas.NOVO_QUIZ_SCREEN) },
                        btConfirmar = {
                            quizes.add(
                                QuizQuestions(
                                    id = item.id,
                                    assunto = item.nome,
                                    timePorQuestao = (valorLinhaTempo.value / 950 * 60).toInt(),
                                    qtdQuestoes = (valorLinha.value / 950 * 20).toInt()
                                )
                            )
                            navController.navigate("${AppRotas.QUIZ_QUESTIONS}/${item.id}")
                        }
                    )
                }
            }
        }
        composable("${AppRotas.TELA_RESULTADOS}/{id}") {
            val id = it.arguments?.getString("id")
            val quizAtual = historicoQuiz.firstOrNull { it.id == id }
            val alternativasSelecionadas = quizAtual?.alternativasSelecionadas
            val questoes = quizAtual?.questoes()

            if ((questoes != null)) {
                if (alternativasSelecionadas != null) {
                    val totalQuestoes = questoes.size
                    val index = remember {
                        val indexValue = 0
                        mutableStateOf(indexValue)
                    }
                    if (index.value < 0) {
                        index.value = 0
                    }
                    if (index.value > totalQuestoes - 1) {
                        index.value = totalQuestoes - 1
                    }
                    val selectedOption = remember {
                        val opcao = quizAtual.alternativasSelecionadas[index.value]
                        mutableStateOf(opcao)
                    }
                    val acertou = remember {
                        mutableStateOf(false)
                    }
                    acertou.value =
                        quizAtual.alternativasSelecionadas[index.value] == questoes[index.value].alternativaCorreta
                    Log.i("valorIndex", questoes[index.value].alternativaCorreta)

                    OvervierQuizScreen(questao = questoes[index.value],
                        numQuestaoAtual = index.value + 1,
                        opcaoSelecionada = selectedOption.value,
                        btFechar = { navController.navigate(AppRotas.HOME_USER) },
                        btAvancar = {
                            if (index.value <= totalQuestoes - 1) {
                                index.value += 1
                            }
                            if (index.value > totalQuestoes - 1) {
                                index.value = totalQuestoes - 1
                            }
                            selectedOption.value = alternativasSelecionadas[index.value]
                        },
                        btVotlar = {
                            if (index.value > 0) {
                                index.value -= 1
                            }
                            if (index.value < 0) {
                                index.value = 0
                            }
                            selectedOption.value = alternativasSelecionadas[index.value]
                        })

                }

            }
        }
    }
}

@Composable
fun SkillsterApp(
    bottomAppBarItemSelected: MutableState<BarItem?>,
    onBottomAppBarItemSelectedChange: (BarItem) -> Unit = {},
    showBars: Boolean,
    content: @Composable () -> Unit,
) {
    Scaffold(
        topBar = {
            if (showBars) {
                ScaffolTopBar(
                    barItem = bottomBarItens.last(),
                    itemChange = onBottomAppBarItemSelectedChange
                )
            }
        },
        bottomBar = {
            if (showBars) {
                ScaffolBottomBar(
                    itens = bottomBarItens.dropLast(1),
                    barItem = bottomAppBarItemSelected,
                    itemChange = onBottomAppBarItemSelectedChange
                )
            }
        }

    ) {
        Box(modifier = Modifier.padding(it)) {
            content()
        }

    }
}