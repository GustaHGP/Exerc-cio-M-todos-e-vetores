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
	 * Ler uma nota do usuário
	 * @param mensagem O texto que aparecerá na tela
	 * @return um número double representando a nota.
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
  * @param indiceNota um número inteiro representando o índice (posição) da nota no vetor
  */
  static void atualizarNota(int indiceNota) {

    System.out.println();
    notas[indiceNota] = lerNota(NOMES_AVALIACOES[indiceNota], NOTA_MAX_AVALIACOES[indiceNota]);
  
  } // Fim do método atualizarNota

  
 /**
  * @param notaFinal A soma de todas as avalições feita pelo estudante ao longo do semestre
  * @return uma string representando o status final do estudante, são eles: APROVADO, REPROVADO, EM RECUPERAÇÃO.
  */
  static String avaliarSituacao(double notaFinal) {

    if(notaFinal < 30)
      return "REPROVADO";
    else if (notaFinal < 70)
      return "EM RECUPERAÇÃO";
    else
      return "APROVADO";
    
  } // Fim do método avaliarSituacao()
  
/*Implemente a função String maiorNota(double[] notas); 
 * que receba como parâmetro o resultado das 3 avaliações feitas pelo estudante 
 * e retorne uma string com o nome da maior nota dele no semestre dentre as avaliações. 
 * Para fazer essa questão, considere o valor de retorno os nomes das avaliações que estão na 
 * constante NOMES_AVALIACOES. 
 * Faça a chamada deste método dentro do procedimento mostrarNotas(); 
 * logo abaixo do comando que mostra na tela a média do aluno, e mostre na tela a
 * a avaliação que o aluno obteve melhor desempenho no semestre.
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
  }/*Fim do método maiorNota()*/

/*Implemente o método calcularMedia(double[] notas); que receba como parâmetro o resultado das 3 avaliações feitas pelo estudante e retorne a média aritmética. Faça a chamada deste método dentro do procedimento mostrarNotas(); logo abaixo do comando que mostra na tela a situação do aluno, e mostre na tela a média de notas do aluno no semestre.
Cole aqui o método calcularMedia(double[] notas)*/
  /*static void calcularMedia1(double a[]) {
	  double c[]=new double[3];
	  double d;
	  for(int b=0;b<a.length;b++)
	  {
		  c[b]=a[b];
	  }
	  d=((c[0]+c[1]+c[2])/3);
	System.out.println("A media do estudante é: "+d);
	  
  }/*Fim do método calcularMedia1()*/
  
  static double calcularMedia2(double a[]) {
	  double c[]=new double[3];
	  double d;
	  for(int b=0;b<a.length;b++)
	  {
		  c[b]=a[b];
	  }
	  d=((c[0]+c[1]+c[2])/3);
	return d;
	  
  }/*fim do método calcularMedia2()*/;
  
  /*Segundo as regras da universidade, se um determinado estudante obteve uma nota final menor do que 70 pontos ele tem direito de fazer a Avaliação Integrada (AI). 
   *Esta avaliação vale 30 pontos e o resultado dela substituirá a menor nota entre as avaliações A1 e A2 apenas. 
   *Caso ocorra a substituição das notas A1 ou A2 pela avaliação AI, o resultado final (A1 + A2 + A3), considerando a substituição, deverá ser 70 pontos ou mais para aprovação. 
   */
  /*Implemente a funcionalidade que leia do usuário a nota da Avaliação Integrada (AI) caso o estudante esteja com a situação EM RECUPERAÇÃO; 
   * faça a substituição da menor nota e mostre na tela a situação final do aluno, ou seja, se foi aprovado ou reprovado após a Avaliação Integrada (AI)
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
	 System.out.println("E a sua situacao é: REPROVADO");
	 }
	 else 
	 {
		System.out.println("E a sua situacao final é: Aprovado"); 
	 }
}
  
  /**
  * Mostra na tela um relatório das notas do estudante
  */
  static void mostrarNotas() {

    double notaFinal = 0.0;

    System.out.println("\n\t\tNOTAS");
    System.out.println();

    for (int i = 0; i < TOTAL_AVALIACOES; i++) {

      System.out.printf("Avaliação %s = %.2f pts", NOMES_AVALIACOES[i], notas[i]);
      System.out.println();
      notaFinal += notas[i];
    
    }
    System.out.println("A maior nota do aluno foi: "+maiorNota(notas));
    /*calcularMedia1(notas);*/
    System.out.println("A media do estudante é:"+calcularMedia2(notas));
    System.out.printf("\n  Nota Final = %.2f pts", notaFinal);
    System.out.printf("\n    Situação = %s", avaliarSituacao(notaFinal));
    if(notaFinal<70)
    {
    	CalcularAI(notas);
    }
  } // Fim do método mostrarNotas()

  
 /**
  * Exibe o menu principal da aplicação
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

    System.out.print("\nDigite uma opção:  ");
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

  } // Fim do método mostrarMenu()

}//Fim da classe Main
  public static void main(String[] args) {
    
    Main.mostrarMenu();
  
  } // Fim do método main();

}
