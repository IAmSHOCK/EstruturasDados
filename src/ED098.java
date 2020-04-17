/* -----------------------------------
  Estruturas de Dados 2019/2020
  Triagem de Manchester [ED098]  
----------------------------------- */

import java.util.Scanner;
import java.util.LinkedList;

// Classe para representar um Doente
class Doente 
{
    public String nome;     // Nome
    public int chegada;     // Tempo de chegada
    public int atendimento; // Tempo que demora a ser atendido
    public int entrada;     // Tempo em que comecou a ser atendido

    // Construtor: inicializa os atributos
    Doente(String n, int c, int a) 
    {
		nome        = n;
		chegada     = c;
		atendimento = a;
		entrada     = -1;
    }
}

// Classe para representar uma fila de atendimento de uma cor (necessaria criar array)
// (nota: Java nao permite criacao direta de array de genericos)
class FilaAtendimento 
{
    public MyQueue<Doente> fila;

    FilaAtendimento() 
    {
		fila = new LinkedListQueue<Doente>();
    }
}

// Classe para representar uma equipa da urgencia
class Equipa 
{
    int numDoentes;       // Numero de doentes que atenderam
    int totalAtendimento; // Total de tempo passado a atender
    int livre;            // Tempo em que ficam livres para poder atender novo doente

    Equipa() 
    {
		numDoentes       = 0;
		totalAtendimento = 0;
		livre            = 0;
    }

    // Novo doente d comecou a ser atendido num dado tempo t nesta equipa
    void novoDoente(Doente d, int t) 
    {
    	this.numDoentes++;
    	this.livre = t + d.atendimento;
    	this.totalAtendimento += d.atendimento;
    }
}

// Classe principal que contem o metodo main
class ED098 
{
    // Constantes que nao mudam durante o programa: numero de cores e seus nomes
    private static final int NUM_CORES = 5;
    private static final String[] CORES = {"Vermelho","Laranja","Amarelo","Verde","Azul"};

    private static int numEquipas;               // Numero de equipas
    private static int numDoentes;               // Numero total de doentes
    private static FilaAtendimento emEspera[];   // Array com uma fila para cada cor
    private static LinkedList<Doente> atendidos; // Lista de doentes ja atendidos
    private static Equipa equipas[];             // Equipas da urgencia

    // Metodo para devolver indice de uma cor representada pela string s
    private static int indiceCor(String s) 
    {
		for (int i = 0; i < NUM_CORES; i++) 
		{
			if(s.equals(CORES[i])) return i;
		}
    	return -1;
    }	

    // Ler os doentes a partir do input e coloca-los nas respetivas filas
    private static void lerDoentes(Scanner in) 
    {	
		while (in.hasNext()) 
		{
		    String nome     = in.next();
		    String cor      = in.next();
		    int chegada     = in.nextInt();
		    int atendimento = in.nextInt();
		    Doente d = new Doente(nome, chegada, atendimento);

		    int i = indiceCor(cor);
		    emEspera[i].fila.enqueue(d);
		    numDoentes++;
		}
    }

    // Mostrar numero de doentes em cada cor (necessario para flag==0)
    private static void mostrarCores() 
    {
		System.out.println("------------");
		System.out.println("Cores     ND");
		System.out.println("------------");

		for (int i = 0; i < NUM_CORES; i++) 
		{
			System.out.printf("%8s %3d\n" , CORES[i], emEspera[i].fila.size());		
		}
		System.out.println("------------");
		System.out.println("Numero doentes atendidos: " + numDoentes);
    }
    

    // Mostrar estatisticas dos doentes atendidos (necessario para flag==1 e flag==2)
    private static void mostrarAtendidos() 
    {
		System.out.println("---------------------------");
		System.out.println("Lista dos doentes atendidos");
		System.out.println("---------------------------");

		int espera = 0;
		double media_espera = 0.0;

		// itera sobre todos os doentes jÃ¡ atendidos (instruÃ§Ã£o for-each)
		for (Doente d : atendidos) 
		{ 
			espera = d.entrada - d.chegada;
			media_espera += espera;
			int saida = d.entrada + d.atendimento;
		    System.out.println(d.nome +" "+ d.chegada +" "+ espera +" " + saida);
		}
		System.out.println("---------------------------");

		media_espera /= atendidos.size();
		System.out.printf("Tempo medio de espera: %.1f\n",	 media_espera);
    }	



    // Mostrar estatisticos das equipas (necessario para flag==2)
    private static void mostrarEquipas() 
    {
		System.out.println("-----------------------");
		System.out.println("Equipa NDoentes MediaTA");
		System.out.println("-----------------------");

		double media = 0;
		for (int i = 0; i < numEquipas; i++ ) 
		{
			if(equipas[i].numDoentes == 0) media = 0;
			else media = equipas[i].totalAtendimento/equipas[i].numDoentes;
			System.out.printf("%5d %8d %7f\n", i, equipas[i].numDoentes, media);
		}
		System.out.println("-----------------------");
    }

    // Qual a cor da proxima equipa a ficar livre?
    private static int proximaEquipaLivre() 
    {
    	int menor_tempo = equipas[0].livre;
		for(int i = 1; i < numEquipas; i++)
		{
			if(equipas[i].livre < menor_tempo) menor_tempo = equipas[i].livre;
		}
		return menor_tempo;
    }

    // Qual a cor mais prioritaria com doente ainda por ser atendido no tempo atual?
    private static int proximoDoente(int tempo) 
    {
    	Doente d;
 	   	for (int i = 0; i < NUM_CORES; i++) 
 	   	{
 	   		if(!emEspera[i].fila.isEmpty())
 	   		{
 	   			d = emEspera[i].fila.first();
    			if(d.chegada <= tempo) return i;
 	   		}
 	   		
    	}
		return -1;
    }


    // Simular processo de atendimento pelas varias equipas medicas
    private static void simular() 
    {
    	int e;
    	int tempo = 0;
    	while(atendidos.size() < numDoentes)
    	{
    		e = proximaEquipaLivre();
    		tempo = e;
    		while(proximoDoente(tempo) == -1) 
    		{
    			tempo++;
    		} 
    		
			Doente d = emEspera[proximoDoente(tempo)].fila.dequeue();
	    	equipas[e].novoDoente(d, tempo); 
	    	d.entrada = tempo;
	    	atendidos.addLast(d);
    		/*
    		System.out.println("tempo " + tempo);
    		System.out.println("atendidos.size() " + atendidos.size());
    		System.out.println("numDoentes " + numDoentes);*/
    	}
    }

    // Inicializar variaveis
    private static void inicializar() 
    {
		numDoentes = 0;

		emEspera = new FilaAtendimento[NUM_CORES];	
		for (int i=0; i<NUM_CORES;i++)
		    emEspera[i] = new FilaAtendimento();

		atendidos = new LinkedList<Doente>();

		equipas = new Equipa[numEquipas];
		for (int i=0; i<numEquipas; i++)
		    equipas[i] = new Equipa();
    }

    // ----------------------------------------------------------------

    // Funcao principal chamada no inicio do codigo
    public static void main(String[] args) 
    {
		Scanner in = new Scanner(System.in);
		int flag   = in.nextInt();
		numEquipas = in.nextInt();
		
		inicializar();
		lerDoentes(in);

		if (flag==0) 
		{
		    mostrarCores();
		} else 
		{
		    simular();
		    if (flag==2) mostrarEquipas(); 
		    mostrarAtendidos();
		}
    }
}