package arrays;
import java.util.Scanner;
public class diego {

class Main {

  static Scanner console = new Scanner(System.in);

  static final int TOTAL_AVALIACOES = 3;
  static final String[] NOMES_AVALIACOES = { "A1", "A2", "A3" };
  static final double[] NOTA_MAX_AVALIACOES = { 30.00, 30.00, 40.00 };
  
  static double[] notas = new double [TOTAL_AVALIACOES];

  
  /**
	 * Ler uma nota do usu�rio
	 * @param mensagem O texto que aparecer� na tela
	 * @return um n�mero double representando a nota.
	 */
	static double lerNota(String mensagem, double notaMaxima) {

      double nota = 0.0;

      do {

        System.out.printf("%s = ", mensagem);
        nota = console.nextDouble();
        
      } while (nota < 0.00 || nota > notaMaxima);

    return nota;
	}

  
  /**
  * Atualiza o valor da respectiva nota do estudante
  * @param indiceNota um n�mero inteiro representando o �ndice (posi��o) da nota no vetor
  */
  static void atualizarNota(int indiceNota) {

    System.out.println();
    notas[indiceNota] = lerNota(NOMES_AVALIACOES[indiceNota], NOTA_MAX_AVALIACOES[indiceNota]);
  
  } // Fim do m�todo atualizarNota

  
 /**
  * @param notaFinal A soma de todas as avali��es feita pelo estudante ao longo do semestre
  * @return uma string representando o status final do estudante, s�o eles: APROVADO, REPROVADO, EM RECUPERA��O.
  */
  static String avaliarSituacao(double notaFinal) {

    if(notaFinal < 30)
      return "REPROVADO";
    else if (notaFinal < 70)
      return "EM RECUPERA��O";
    else
      return "APROVADO";
    
  } // Fim do m�todo avaliarSituacao()
  
/*Implemente a fun��o String maiorNota(double[] notas); 
 * que receba como par�metro o resultado das 3 avalia��es feitas pelo estudante 
 * e retorne uma string com o nome da maior nota dele no semestre dentre as avalia��es. 
 * Para fazer essa quest�o, considere o valor de retorno os nomes das avalia��es que est�o na 
 * constante NOMES_AVALIACOES. 
 * Fa�a a chamada deste m�todo dentro do procedimento mostrarNotas(); 
 * logo abaixo do comando que mostra na tela a m�dia do aluno, e mostre na tela a
 * a avalia��o que o aluno obteve melhor desempenho no semestre.
 */
  static String maiorNota(double m[])
  {
	  String a="";
	  double maior=0;
	  for(int i=0;i<m.length;i++)
	  {
		 if(i==0)
		 {
			 maior=m[i];
		 }
		 else if(maior<m[i])
		 {
			 maior=m[i];
		 }
	  }
	  a=(""+maior);
	  return a;
  }/*Fim do m�todo maiorNota()*/

/*Implemente o m�todo calcularMedia(double[] notas); que receba como par�metro o resultado das 3 avalia��es feitas pelo estudante e retorne a m�dia aritm�tica. Fa�a a chamada deste m�todo dentro do procedimento mostrarNotas(); logo abaixo do comando que mostra na tela a situa��o do aluno, e mostre na tela a m�dia de notas do aluno no semestre.
Cole aqui o m�todo calcularMedia(double[] notas)*/
  /*static void calcularMedia1(double a[]) {
	  double c[]=new double[3];
	  double d;
	  for(int b=0;b<a.length;b++)
	  {
		  c[b]=a[b];
	  }
	  d=((c[0]+c[1]+c[2])/3);
	System.out.println("A media do estudante �: "+d);
	  
  }/*Fim do m�todo calcularMedia1()*/
  
  static double calcularMedia2(double a[]) {
	  double c[]=new double[3];
	  double d;
	  for(int b=0;b<a.length;b++)
	  {
		  c[b]=a[b];
	  }
	  d=((c[0]+c[1]+c[2])/3);
	return d;
	  
  }/*fim do m�todo calcularMedia2()*/;
  
  /*Segundo as regras da universidade, se um determinado estudante obteve uma nota final menor do que 70 pontos ele tem direito de fazer a Avalia��o Integrada (AI). 
   *Esta avalia��o vale 30 pontos e o resultado dela substituir� a menor nota entre as avalia��es A1 e A2 apenas. 
   *Caso ocorra a substitui��o das notas A1 ou A2 pela avalia��o AI, o resultado final (A1 + A2 + A3), considerando a substitui��o, dever� ser 70 pontos ou mais para aprova��o. 
   */
  /*Implemente a funcionalidade que leia do usu�rio a nota da Avalia��o Integrada (AI) caso o estudante esteja com a situa��o EM RECUPERA��O; 
   * fa�a a substitui��o da menor nota e mostre na tela a situa��o final do aluno, ou seja, se foi aprovado ou reprovado ap�s a Avalia��o Integrada (AI)
   */
static void CalcularAI(double notas[])
{
	Scanner AI=new Scanner(System.in);
	double Ai;
	System.out.printf("\nDigite a nota da AI: ");
	  Ai=AI.nextDouble();
	  if(notas[0]<Ai)
	  {
		  notas[0]=Ai;
	  }
	  else if(notas[1]<Ai)
	  {
		  notas[1]=Ai;
	  }
	 System.out.println("A sua nota final nova ficou:"+(notas[0]+notas[1]+notas[2]));
	 if(notas[0]+notas[1]+notas[2]<70)
	 {
	 System.out.println("E a sua situacao �: REPROVADO");
	 }
	 else 
	 {
		System.out.println("E a sua situacao final �: Aprovado"); 
	 }
}
  
  /**
  * Mostra na tela um relat�rio das notas do estudante
  */
  static void mostrarNotas() {

    double notaFinal = 0.0;

    System.out.println("\n\t\tNOTAS");
    System.out.println();

    for (int i = 0; i < TOTAL_AVALIACOES; i++) {

      System.out.printf("Avalia��o %s = %.2f pts", NOMES_AVALIACOES[i], notas[i]);
      System.out.println();
      notaFinal += notas[i];
    
    }
    System.out.println("A maior nota do aluno foi: "+maiorNota(notas));
    /*calcularMedia1(notas);*/
    System.out.println("A media do estudante �:"+calcularMedia2(notas));
    System.out.printf("\n  Nota Final = %.2f pts", notaFinal);
    System.out.printf("\n    Situa��o = %s", avaliarSituacao(notaFinal));
    if(notaFinal<70)
    {
    	CalcularAI(notas);
    }
  } // Fim do m�todo mostrarNotas()

  
 /**
  * Exibe o menu principal da aplica��o
  */
  static void mostrarMenu() {

    System.out.println("\n\n");
    System.out.println("\t\tMENU");
    System.out.println();
    
    System.out.println("[1] Cadastrar Notas A1");
    System.out.println("[2] Cadastrar Nota A2");
    System.out.println("[3] Cadastrar Nota A3");
    System.out.println("[4] Mostrar Notas");
    System.out.println("[0] SAIR");

    System.out.print("\nDigite uma op��o:  ");
    byte opcao = console.nextByte();


    switch(opcao) {

      case 0:
        System.exit(0);
        break;
      
      case 1:
        atualizarNota(0);
        break;
      
      case 2:
        atualizarNota(1);
        break;

      case 3:
        atualizarNota(2);
        break;

      case 4:
        mostrarNotas();
        break;

      default:
        mostrarMenu();
        break;

    }

    mostrarMenu();

  } // Fim do m�todo mostrarMenu()

}//Fim da classe Main
  public static void main(String[] args) {
    
    Main.mostrarMenu();
  
  } // Fim do m�todo main();

}
