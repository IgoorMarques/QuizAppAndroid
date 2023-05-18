package com.igor.appinovatec.controllers.AppRotas

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
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
import kotlinx.coroutines.delay

class rotas : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
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


@RequiresApi(Build.VERSION_CODES.O)
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
            val itemSelecionado = remember {
                val item: QuizQuestions? = null
                mutableStateOf(item)
            }
            val mostrarTelaAviso = remember {
                mutableStateOf(false)
            }
            val msgTelaPrincipal = remember {
                mutableStateOf("Não há quizzis por aqui")
            }

            TelaPrincipal(menuItemSelected = homeItemSelected.value,
                onMenuItemSelectedChange = {
                    if (it.rota == AppRotas.HOME_emAndamento) {
                        homeItemSelected.value = it
                        msgTelaPrincipal.value = "Não há quizzis por aqui"
                    }
                    if (it.rota == AppRotas.HOME_PENDENTE) {
                        homeItemSelected.value = it
                        msgTelaPrincipal.value = "Nada recebido por enquanto"
                    }
                    if (it.rota == AppRotas.HOME_HISTORICO) {
                        homeItemSelected.value = it
                        msgTelaPrincipal.value = "Nada feito até agora"
                    }
                }
            ) {
                if (homeItemSelected.value.rota == AppRotas.HOME_emAndamento) {
                    if (userQuizes.isEmpty()) {
                        EmptyConteudo(
                            msgTelaPrincipal = msgTelaPrincipal.value,
                            homeItemSelected = homeItemSelected.value.rota
                        ) {
                            navController.navigate(AppRotas.NOVO_QUIZ_SCREEN)
                        }
                    } else if (homeItemSelected.value.rota == AppRotas.HOME_emAndamento) {
                        userQuizes.forEach { item ->
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
                }
                else if (homeItemSelected.value.rota == AppRotas.HOME_PENDENTE) {
                    if (quizesRecebidos.isEmpty()) {
                        EmptyConteudo(
                            msgTelaPrincipal = msgTelaPrincipal.value,
                            homeItemSelected = homeItemSelected.value.rota
                        ) {

                        }
                    } else {
                        quizesRecebidos.forEach { item ->
                            item.infoQuiz?.let { it1 ->
                                TelaItem(item = it1, onClick = { /*TODO*/ },
                                    onDeleteClick = {
                                        showAlertDialog.value = true
                                        contentItemSelected.value = item
                                    })
                            }
                        }
                    }
                }
                else if (homeItemSelected.value.rota == AppRotas.HOME_HISTORICO) {
                    if (historicoQuiz.isEmpty()) {
                        EmptyConteudo(
                            msgTelaPrincipal = msgTelaPrincipal.value,
                            homeItemSelected = homeItemSelected.value.rota
                        ) {}
                    } else {
                        historicoQuiz.forEach { item ->
                            item.infoQuiz?.let { it1 ->
                                TelaItem(item = it1,
                                    onClick = { navController.navigate("${AppRotas.TELA_RESULTADOS}/${it.id}") },
                                    onDeleteClick = {
                                        showAlertDialog.value = true
                                        contentItemSelected.value = item
                                    }
                                )
                            }
                        }
                    }
                }
                if (showAlertDialog.value.and(contentItemSelected.value != null)) {
                    contentItemSelected.value?.infoQuiz?.let { it1 -> Log.i("valorHomeItem", it1.rota) }
                    ConfirmationDialog(message = "Tem certeza que deseja remover esse item?",
                        onDismiss = {
                            showAlertDialog.value = false
                        },
                        onConfirm = {

                            if (contentItemSelected.value?.infoQuiz?.rota == AppRotas.HOME_emAndamento) {
                                userQuizes.remove(contentItemSelected.value)
                            }
                            if (contentItemSelected.value?.infoQuiz?.rota == AppRotas.HOME_PENDENTE) {
                                quizesRecebidos.remove(contentItemSelected.value)
                            }
                            if (contentItemSelected.value?.infoQuiz?.rota == AppRotas.HOME_HISTORICO) {
                                historicoQuiz.remove(contentItemSelected.value)
                            }
                            showAlertDialog.value = false
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
            val quizAtual = userQuizes.firstOrNull { it.id == id }
            if (quizAtual != null) {
                val isCheckboxSelected = remember { mutableStateOf(false) }
                val tempo = remember {
                    val time = quizAtual.timePorQuestao.toLong()
                    mutableStateOf(time)
                }
                Log.i("tempoQuiz", "${tempo.value}")
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
                            LaunchedEffect(key1 = Unit) {
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
                                userQuizes.remove(quizAtual)
                                navController.navigate(AppRotas.HOME_USER)
                            },
                                btQuestoes = {
                                    userQuizes.remove(quizAtual)
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
                val status = btLevelTelaConfig.first().name
                mutableStateOf(status)
            }
            val btQtdQuestoesSelected = remember {
                val status = btQtdQuestoesTelaConfig.first().name
                mutableStateOf(status)
            }
            val btTempoSelected = remember {
                val status = btTempoTelaConfig.first().name
                mutableStateOf(status)
            }
            val btQuizConfigSelected = remember {
                val status = btQuizConfig.first().name
                mutableStateOf(status)
            }
            val id = navBackStackEntry.arguments?.getString("areaId")
            if (id != null) {
                val item = areasQuiz.find { it.id == id }
                if (item != null) {
                    TelaConfigQuiz(
                        itemQuiz = item,
                        selectedBtLevel = btNivelSelected.value,
                        selectedBtQtdQuestoes = btQtdQuestoesSelected.value,
                        selectedBtTempoQuestao = btTempoSelected.value,
                        selectedQuizConfig = btQuizConfigSelected.value,
                        btLevelClicked = { btNivelSelected.value = it.name },
                        btTempoClicked = { btTempoSelected.value = it.name },
                        btQuizConfigClicked = { btQuizConfigSelected.value = it.name },
                        btCancelar = { navController.navigate(AppRotas.NOVO_QUIZ_SCREEN) },
                        btQtdQuestoesClicked = { btQtdQuestoesSelected.value = it.name }
                    ) {
                        userQuizes.add(
                            QuizQuestions(
                                id = item.id,
                                assunto = item.nome,
                                timePorQuestao = btTempoSelected.value.toInt(),
                                qtdQuestoes = btQtdQuestoesSelected.value.toInt(),
                                infoQuiz = HomeContentItem(
                                    id = item.id,
                                    title = if (btQuizConfigSelected.value == btQuizConfig.first().name) "Iniciado" else "Não iniciado",
                                    assunto = item.nome,
                                    quizStatus = "Questões: 0/${btQtdQuestoesSelected.value}",
                                    data = dataHoraAtual(),
                                    bt_action = "Iniciar",
                                    rota = AppRotas.HOME_emAndamento
                                )
                            )
                        )
                        if (btQuizConfigSelected.value == btQuizConfig.first().name) {
                            navController.navigate("${AppRotas.QUIZ_QUESTIONS}/${item.id}")
                        } else {
                            navController.navigate(AppRotas.HOME_USER)
                        }
                    }
                }
            }
        }
        composable("${AppRotas.TELA_RESULTADOS}/{id}") { it ->
            val id = it.arguments?.getString("id")
            val quizAtual = historicoQuiz.firstOrNull { it.id == id }
            if (quizAtual != null) {
                Log.i("idTelaResults", quizAtual.id)
            }
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


@Composable
fun EmptyConteudo(msgTelaPrincipal: String, homeItemSelected: String, novoQuiz: () -> Unit) {
    Box(
        modifier = Modifier
            .height(
                300.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                Icons.Filled.Info, "status",
                tint = Color.Yellow, modifier = Modifier.size(100.dp)
            )
            Text(text = msgTelaPrincipal)
            if (homeItemSelected == AppRotas.HOME_emAndamento) {
                Text(text = "Gerar novo quiz")
                Icon(Icons.Rounded.Add, contentDescription = "NovoQuiz",
                    modifier = Modifier.clickable {
                        novoQuiz()
                    })
            }
        }

    }
}