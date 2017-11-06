//codigos para a prova

//TAD Dinamica
class Celula
{
	public int elemento;
	public Celula prox;
	public Celula(){this(0);}
	public Celula(int valor)
	{
		this.elemento = valor;
		this.prox = null;
	}
}
/*-----------------------------------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------------------------------*/
class Lista
{
	public Celula primeiro, ultimo;

	public Lista()
	{
		this.primeiro = new Celula();
		this.ultimo = this.primeiro;
	}

	public void inserirInicio(int x)
	{
		Celula tmp = new Celula(x);
		tmp.prox = this.primeiro.prox;
		this.primeiro.prox = tmp;
		if(this.primeiro == this.ultimo)
		{
			this.ultimo = tmp;
		}
		tmp = null;
	}

	public void inserirFim(int x)
	{
		this.ultimo.prox = new Celula(x);
		this.ultimo = this.ultimo.prox;
	}

	public int tamanho()
	{
		int tam =0;
		for(Celula i = this.primeiro; i != ultimo; i = i.prox, tam++);
		return tam;
	}

	public void inserir(int x, int pos) throws Exception
	{
		if(pos < 0 || pos > tamanho())
		{
			throw new Exception("ERROR");
		}else if(pos == 0){
			inserirInicio(x);
		}else if(pos == tamanho()){
			inserirFim();
		}else{
			Celula i = this.primeiro;
			for(int j =0; j != pos; j++, i = i.prox);

			Celula tmp = new Celula(x);
			tmp.prox = i.prox;
			i.prox = tmp;
			tmp = i = null;
		}
	}

	public int removerInicio() throws Exception
	{
		if(this.primeiro == this.ultimo)
		{
			throw new Exception("ERROR");
		}

		Celula tmp = this.primeiro;
		this.primeiro = this.primeiro.prox;
		int elemento = this.primeiro.elemento;
		tmp.prox = null;
		tmp = null;

		return elemento;
	}

	public int removerFim() throws Exception
	{
		if(this.primeiro == this.ultimo)
		{
			throw new Exception("ERROR");
		}

		Celula i;
		for(i = this.primeiro; i != ultimo; i = i.prox);

		int elemento = this.ultimo.elemento;
		this.ultimo = i;
		this.ultimo.prox = i = null;

		return elemento;
	}

	public int remover(int pos)throws Exception
	{
		int elemento;
		if(this.primeiro == this.ultimo)
		{
			throw new Exception("ERROR!");
		}else if(pos < 0 || pos > tamanho){
			throw new Exception("ERROR");
		}else if(pos == 0){
			elemento = removerInicio();
		}else if(pos == tamanho()){
			elemento = removerFim();
		}else{
			Celula i;
			for(int j = 0; j != pos; j++, i = i.prox);

			Celula tmp = i.prox;
			int elemento = tmp.elemento;
			i.prox = tmp.prox;

			tmp.prox = null;
			tmp = null;
		}
		return elemento;
	}

	public void mostrar()
	{
		mostrar(this.primeiro.prox);
	}

	public void mostrar(Celula i)
	{
		if(i != null)
		{
			System.out.println(i.elemento);
			mostrar(i.prox);
		}
	}
}
/*-----------------------------------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------------------------------*/
class Fila
{
	Celula primeiro, ultimo;

	public Fila()
	{
		this.primeiro = new Celula();
		this.ultimo = this.primeiro;
	}
	//semelhante ao inserirFim()
	public void inserir(int x)
	{
		this.ultimo.prox = new Celula(x);
		this.ultimo = this.ultimo.prox;
	}

	//semelhante ao removerInicio
	public int remover()throws Exception
	{	
		if(this.primeiro == this.ultimo)
		{
			throw new Exception("ERROR");
		}

		Celula tmp = this.primeiro;
		this.primeiro = this.primeiro.prox;
		int elemento = this.primeiro.elemento;
		tmp.prox = null;
		tmp = null;
	}

	public void mostrar()
	{
		mostrar(this.primeiro.prox);
	}

	public void mostrar(Celula i)
	{
		if(i != null)
		{
			System.out.println(i.elemento);
			mostrar(i.prox);
		}
	}
}
/*-----------------------------------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------------------------------*/
class Pilha
{
	Celula topo;

	public Pilha(){this.topo = null;}

	public void inserir()
	{
		Celula tmp = new Celula();
		tmp.prox = this.topo;
		this.topo = tmp;
		tmp = null;	
	}

	public int remover()
	{
		int elemento = this.topo.elemento;
		Celula tmp = this.topo;
		this.topo = this.topo.prox;
		tmp.prox = null;
		tmp = null;
	}

	public void mostrar()
	{
		mostrar(this.topo);
	}

	public void mostrar(Celula i)
	{
		if(i != null)
		{
			System.out.println(i.elemento);
			mostrar(i.prox);
		}
	}
}
/*-----------------------------------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------------------------------*/
class CelulaDupla
{
	public int elemento;
	public CelulaDupla prox, ant;
	public CelulaDupla(){this(0);}
	public CelulaDupla(int x)
	{
		this.elemento = x;
		this.prox = this.ant = null;
	}
}

class ListaDupla
{
	private CelulaDupla primeiro, ultimo;

	public ListaDupla()
	{
		this.primeiro = new CelulaDupla(x);
		this.ultimo = this.primeiro;
	} 

	public int tamanhoD()
	{
		int tam = 0;
		for(CelulaDupla i = this.primeiro; i != this.ultimo; tam++, i = i.prox);
		return tam;
	}

	public void inserirInicio(int x)
	{
		CelulaDupla tmp = new CelulaDupla(x);

		tmp.prox = this.primeiro.prox;
		tmp.ant  = this.primeiro;
		this.primeiro.prox = tmp;
		if(this.primeiro == this.ultimo)
		{
			this.ultimo = tmp;
		}else{
			this.tmp.prox.ant = tmp;
		}
		tmp = null;
	}

	public void inserirFim(int x)
	{
		this.ultimo.prox = new CelulaDupla(x);
		this.ultimo.prox.ant = this.ultimo;
		this.ultimo = this.ultimo.prox;
	}

	public void inserir(int x, int pos) throws Exception
	{
		if(pos < 0 || pos > tamanhoD())
		{
			throw new Exception("ERROR!");
		}else if(pos == 0){
			inserirInicio(x);
		}else if(pos == tamanhoD()){
			inserirFim();
		}else{
			CelulaDupla i = this.primeiro;
			for(int j = 0; i != pos; j++, i = i.prox);

			CelulaDupla tmp = new CelulaDupla(x);
			tmp.ant  = i;
			tmp.prox = i.prox;
			tmp.prox.ant = tmp.ant.prox = tmp;
			tmp = i = null;
		}
	}

	public int removerInicio()throws Exception
	{	
		if(this.primeiro == this.ultimo)
		{
			throw new Exception("ERROR");
		}

		CelulaDupla tmp = this.primeiro;
		this.primeiro = this.primeiro.prox;
		int elemento = this.primeiro.elemento;
		tmp.prox = this.primeiro.ant = null;
		tmp = null;
		return elemento;
	}

	public int removerFim()throws Exception
	{
		if(this.primeiro == this.ultimo)
		{
			throw new Exception("ERROR!");
		}
		int elemento = this.ultimo.elemento;
		this.ultimo = this.ultimo.ant;
		this.ultimo.prox.ant = null;
		this.ultimo.prox = null;

		return elemento;
	}

	public void remover(int pos) throws Exception
	{
		int elemento;
		if(this.primeiro == this.ultimo)
		{
			throw new Exception("ERROR!");
		}else if(pos < 0 || pos > tamanhoD()){
			throw new Exception("ERROR!");
		}else if(pos == 0){
			elemento = removerInicio();
		}else if(pos == tamanhoD()){
			elemento = removerFim();
		}else{
			CelulaDupla i = this.primeiro;
			for(int j =0; j != pos; i = i.prox);
			int elemento = i.elemento;
			i.ant.prox = i.prox; 
			i.prox.ant = i.ant;
			i.prox = i.ant = null;
			i = null;
		}
		return elemento;
	}
}

/*-----------------------------------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------------------------------*/
class No
{
	public int elemento;
	public No esq, dir;

	public No(int elemento)
	{
		this(elemento, null, null);
	}

	public No(int elemento, No esq, No dir)
	{
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
	}
}

class ArvoreBinaria
{
	private No raiz;

	public ArvoreBinaria(){raiz = null;}

	public void inserir(int elemento) throws Exception
	{
		raiz = inserir(elemento, raiz);
	}

	public No inserir(int x, No i) throws Exception
	{
		if(i == null)
		{
			i = new No(x);
		}else if(x < i.elemento){
			i.esq = inserir(x, i.esq);
		}else if(x > i.elemento){
			i.dir = inserir(x, i.dir);
		}else{
			throw new Exception("ERROR!"); //nao insere valores iguais
		}
		return i;
	}

	public void remover(int x) throws Exception
	{
		raiz = remover(x, raiz);
	}

	public No remover(int x, No i)
	{
		if(i == null)
		{
			throw new Exception("ERROR!");
		}else if(x < i.elemento){
			i.esq = remover(x, i.esq);
		}else if(x > i.elemento){
			i.dir = remover(x, i.dir);
		}else if(i.dir == null){
			i = i.esq;
		}else if(i.esq == null){
			i = i.dir;
		}else{
			i.esq = antecessor(i, i.esq);
		}
		return i;
	}

	//Metodo troca o elemento a ser removido com 
	private No antecessor(No i, No j)
	{
		if(j.dir != null)
		{
			j.dir = antecessor(i, j.dir);
		}else{
			i.elemento = j.elemento;
			j = j.dir;
		}
		return j;
	}

	public boolean pesquisar(int x)
	{
		return pesquisar(x, raiz);
	}

	public boolean pesquisar(int x, No i)
	{
		boolean resp = false;
		if(i == null)
		{
			resp = false;
		}else if(x == i.elemento){
			resp = true;
		}else if(x < i.elemento){
			resp = pesquisar(x, i.esq);
		}else{
			resp = pesquisar(x, i.dir);
		}
		return resp;
	}

	private int cont1 = 0;
	private int cont2 = 0;
	//conta a quantidade de elementos da arvore
	//metodo semelhante ao mostrarCentral()
	public void quantidade()
	{
		if(i != null)
		{
			elementos(i.esq);
			cont2++;
			quantidade(i.dir);
			if(cont2 > cont1)
			{
				cont1 = cont2;
			}
		}
	}

	//calcula a altura de uma arvore
	public int altura()
	{
		 quantidade();
		 int aux = this.cont1-1; //valor sem a raiz, caso a arvore so tenha a raiz o valor da altura deve ser zero 
		 int valor = 0;
		 int cont = 0;
		 while(valor != aux)
		 {
		 	if(valor < cont1)
		 	{
		 		valor = Math.pow(2, cont);
		 		cont++;
		 	}else{
		 		valor--;
		 	}
		 }
	}

	public void mostrarCentral()
	{
		mostrarCentral(raiz);
	}

	public void mostrarCentral(No i)
	{
		if(i != null)
		{
			mostrarCentral(i.esq);
			System.out.println(i.elemento+" ");
			mostrarCentral(i.dir);
		}
	}

	public void mostrarPre()
	{
		mostrarCentral(raiz);
	}

	public void mostrarPre(No i)
	{
		if(i != null)
		{
			System.out.println(i.elemento);
			mostrarPre(i.esq);
			mostrarPre(i.dir);
		}
	}

	public void mostrarPos() 
	{
		mostrarPos(raiz);
	}

	private void mostrarPos(No i) {
		if (i != null) 
		{
			mostrarPos(i.esq); 
			mostrarPos(i.dir); 
			System.out.print(i.elemento + " "); 
		}
	}
}

/*-----------------------------------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------------------------------*/

//Arvore de Lista
class No
{
	public char letra;
	public Celula primeiro, ultimo;
	public No esq, dir;

	public No(char letra)
	{
		this.letra = letra;
		this.esq = this.dir = null;
		this.primeiro = this.ultimo = new Celula();
	}
}

class Celula
{
	Contato elemento;
	Celula prox;
	public Celula(){this(null);}
	public Celula(Contato x)
	{
		this.elemento = x; 
		this.prox = null;
	}
}

class Contato
{
	public String nome;
   	public String telefone;
   	public String email;
   	public int cpf;

   	public Contato(String nome, String telefone, String email, int cpf)
   	{
   		this.nome = nome;
   		this.telefone = telefone;
   		this.email = email;
   		this.cpf = cpf;
   	}
}

class Agenda
{
	private No raiz;
	public Agenda(){raiz = null;}

	public void inserirLetra(char c)
	{
		this.raiz = inserirLetra(c, raiz);
	}

	public No inserirLetra(char c, No i)
	{
		if(i == null)
		{
			i = new No(Char.toUpper(c));
		}else if(c < i.letra){
			i.esq = inserirLetra(c , i.esq);
		}else if(c > i.letra){
			i.dir = inserirLetra(c, i.dir);
		}else{
			throw new Exception("ERROR!");
		}
		return i;
	}

	public No removerLetra(char c)throws Exception
	{
		raiz = removerLetra(c, raiz);
	}

	public No removerLetra(char c, No i)throws Exception
	{
		if(i == null)
		{
			throw new Exception("ERROR!");
		}else if(c < i.letra){
			i.esq = removerLetra(c, i.esq);
		}else if(c > i.letra){
			i.dir = removerLetra(c, i.dir);
		}else if(i.dir == null){
			i = i.esq;
		}else if(i.esq == null){
			i = i.dir;
		}else{
			i.esq = antecessor(i, i.esq);
		}
		return i;
	}

	public No antecessor(No i, No j)
	{
		if(j.dir != null)
		{
			j.dir = antecessor(i, j.dir);
		}else{
			i.letra = j.letra;
			j = j.esq;
		}
		return j;
	}

	public void inserirContato(Contato contato) throws Exception
	{
		raiz = inserirContato(contato, raiz);
	}

	public No inserirContato(Contato x, No i) throws Exception
	{
		if(i == null)
		{
			throw new Exception("ERROR");
		}else if(Char.toUpper(x.nome.charAt(0)) < i.letra){
			i.esq = inserirContato(x, i.esq);
		}else if(Char.toUpper(x.nome.charAt(0)) > i.letra){
			i.dir = inserirContato(x, i.dir);
		}else{
			i.ultimo.prox = new Celula(x);
			i.ultimo = i.ultimo.prox;
		}	
	}

	public void removerContato(Contato contato) throws Exception
	{
		raiz = removerContato(contato, raiz); 
	}

	public No removerContato(Contato x, No i) throws Exception
	{
		if(i == null)
		{
			throw new Exception("ERROR!");
		}else if(Char.toUpper(x.nome.charAt(0)) < i.letra){
			i.esq = removerContato(x, i.esq);
		}else if(Char.toUpper(x.nome.charAt(0)) > i.letra){
			i.dir = removerContato(x, i.dir);
		}else{

		}
	}

	public boolean pesquisarNome(String nome)
	{
		return pesquisarNome(nome, raiz);
	}

	public boolean pesquisarNome(String nome, No i)
	{
		boolean resp = true;
		if(i == null)
		{
			resp = false;
		}else if(Char.toUpper(x.nome.charAt(0)) == i.letra){
			resp = false;
			for(Celula j = j.primeiro.prox; j != null; j = j.prox)
			{
				if(j.nome.equal(nome) == true)
				{
					j == null;
					resp = true;
				}
			}
		}else if(Char.toUpper(x.nome.charAt(0)) < i.letra){
			resp = pesquisarNome(nome, i.esq);
		}else if(Char.toUpper(x.nome.charAt(0)) > i.letra){
			resp = pesquisarNome(nome, i.dir);
		}

		return resp;
	}
}
/*-----------------------------------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------------------------------*/

//Matriz Dinamica

class Celula
{
	public int elemento;
	public Celula sup;
	public Celula inf;
	public Celula dir;
	public Celula esq;
	public int tam; //quantidade de elementos da matriz

	public Celula(int x){this(x, null, null, null, null);}
	public Celula(int x, Celula sup, Celula inf, Celula dir, Celula inf)
	{
		this.elemento = x;
		this.sup = sup;
		this.inf = inf;
		this.esq = esq;
		this.dir = dir;		
	}
}


class Matriz
{
	public Celula inicio;
	public int linha, int coluna;
	public Celula m, n; //ponteiros para percorrer a matriz e salvar a posicao

	public Matriz(){this(0, 0);}
	public Matriz(int linha, int coluna)
	{
		this.inicio = new Celula(0);

		this.linha = linha;
		this.coluna = coluna;
		gerarMatriz();
		this.m = this.n = this.inicio;
		this.tam = 0;
	}

	public void gerarMatriz()
	{
		if(this.linha < 0 || this.coluna < 0)
		{
			System.out.println("ERROR!");
		}

		int lin = 0;
		int col = 0;
		Celula i, j;
		i = j = this.inicio;

		while(lin < this.linha)
		{
			while(col < this.coluna-1)
			{
				j.dir = new Celula(0);
				j.dir.esq = j;
				j = j.dir

				if(j.esq != null && j.esq.sup != null)
				{
					j.sup = j.esq.sup.dir;
					j.esq.sup.dir.inf = j;
				}
				col++;
			}
			i.inf = new Celula(0);
			i.inf.sup = i;
			i = j = i.inf;
			col = 0;
			lin++;
		}
	}

	public void inserir(int valor)throws Exception
	{
		if(this.tam == contar())
		{
			throw new Exception("ERROR: Matriz Cheia");
		}

		if(this.n.dir != null)
		{
			this.n.elemento = valor;
			this.n = this.n.dir;
		}else{
			this.n.elemento = valor;
			this.n = this.m.inf;
			this.m = this.m.inf;
		}
		this.n1++;
	}

	public Matriz somar(Matriz m1, Matriz m2) throws Exception
	{
		if(m1.linha != m2.linha || m1.coluna != m2.coluna)
		{
			throw new Exception("ERROR: Matriz invalida!");
		}

		int soma = 0;
		Celula aux1 = m1.inicio;
		Celula aux2 = m2.inicio;
		Matriz m3 = new Matriz(m1.linha, m1.coluna); //m1 e m2 tem o mesmo tamanho

		for(/*Nada*/;aux1.inf != null; aux1 = aux1.inf, aux2 = aux2.inf)
		{
			for(Celula a1 = aux1, a2 = aux2; a1 != null; a1 = a1.dir, a2 = a2.dir)
			{
				soma = a1.elemento + a2.elemento;
				m3.inserir(soma);
			}
		}

		return m3;
	}


	public void diagonalP()
	{
		Celula i = this.inicio;
		while(i != null)
		{	
			System.out.print(i.elemento+" ");
			i = i.inf;
			if(i != null)
			{
				i = i.dir;
			}
		}
	}

	public void diagonalS()
	{
		Celula i;
		for(i = this.inicio; i.dir != null; i = i.dir);
		while(i != null)
		{
			System.out.print(i.elemento);
			i = i.esq;
			if(i != null)
			{
				i = i.inf;
			}
		}
	}

	/*
 	 * Metodo para contar os elementos de uma matriz
	 */
	public int contar()
	{
		int tam =0;
		for(Celula i = this.inicio; i.inf != null; i = i.inf)
		{
			for(Celula j = i; j != null; j = j.dir)
			{
				tam++;
			}
		}
		return tam;
	}

	public void mostrar()
	{
		for(Celula i = this.inicio; i.inf != null; i = i.inf)
		{
			for(Celula j = i; j != null; j = j.dir)
			{
				Sysmtem.out.println(j.elemento+" ");
			}
			Sysmtem.out.println();
		}
	}
}
/*-----------------------------------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------------------------------*/

class CelulaM
{
	public char letra;
	public CelulaM sup, inf, esq, dir; 
	public Matriz matriz;

	public CelulaM(char c){this(c, null, null, null, null, 0, 0);}
	public CelulaM(char letra, CelulaM sup, CelulaM inf, 
				   CelulaM esq, CelulaM dir, int linha, int coluna)
	{
		this.letra = letra;
		matriz = new Matriz(linha, coluna);
		this.sup = sup;
		this.inf = inf;
		this.esq = esq;
		this.dir = dir;
	}
}

//Matriz de Matriz
class MatrizM
{
	public CelulaM inicio;
	private int linha, coluna;
	private CelulaM m, n;
	private n1;

	public MatrizM(){this(0, 0);}
	public MatrizM(int linha, int coluna)
	{
		this.inicio = CelulaM('0');
		this.linha = linha;
		this.coluna = coluna;
		gerarMatrizM();
		this.m = this.n = this.inicio;
		this.n1 = 0;
	}

	public void gerarMatrizM()
	{
		if(this.linha < 0 || this.coluna < 0)
		{
			throw new Exception("ERROR!");
		}

		int lin = 0;
		int col = 0;
		CelulaM i, j;
		i = j = this.inicio;
		while(lin < this.linha)
		{
			while(col < this.coluna-1)
			{
				j.dir = new CelulaM('0');
				j.dir.esq = j;
				j = j.dir;

				if(j.esq != null && j.esq.sup != null)
				{
					j.sup = j.esq.sup.dir;
					j.esq.sup.dir.inf = j;
				}
				col++;
			}
			i.inf = new CelulaM('0');
			i.inf.sup = i;
			i = j = i.inf;

			col = 0;
			lin++;
		}
	}

	public void inserir(char letra)
	{
		if(this.n1 == contar())
		{
			throw new Exception("ERROR: Matriz Cheia");
		}

		if(this.n.dir != null)
		{
			this.n.letra = letra;
			this.n = this.n.dir;
		}else{
			this.n.letra = letra;
			this.n = this.m.inf;
			this.m = this.m.inf;
		}
		this.n1++;
	}

	public void diagonalP()
	{
		Celula i = this.inicio;
		while(i != null)
		{
			Sysmtem.out.println(i.letra+" ");
			i = i.inf;
			if(i != null)
			{
				i = i.dir;
			}
		}
	}

	public void diagonalS()
	{
		Celula i = this.primeiro;
		for(/*nada*/; i.dir != null; i = i.dir);

		while(i != null)
		{
			System.out.print(i.letra+" ");
			i = i.esq;
			if(i != null)
			{
				i = i.inf;
			}
		}
	}

	public int contar()
	{
		int tam =0;
		for(CelulaM i = this.inicio; i.inf != null; i = i.inf)
		{
			for(CelulaM j = i; j != null; j = j.dir)
			{
				tam++;
			}
		}
		return tam;
	}

	public void mostrar()
	{
		for(Celula i = this.inicio; i.inf != null; i = i.inf)
		{
			for(Celula j = i; j != null; j = j.dir)
			{
				Sysmtem.out.print(i.letra+" ");
			}
			Sysmtem.out.println();
		}
	}

}

/*-----------------------------------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------------------------------*/

//FILA DINAMICA EM C
typedef struct Celula {
	int elemento;        // Elemento inserido na celula.
	struct Celula* prox; // Aponta a celula prox.
} Celula;

Celula* novaCelula(int elemento) {
   Celula* nova = (Celula*) malloc(sizeof(Celula));
   nova->elemento = elemento;
   nova->prox = NULL;
   return nova;
}

//FILA PROPRIAMENTE DITA ========================================================
Celula* primeiro;
Celula* ultimo;


/**
 * Cria uma fila sem elementos (somente no cabeca).
 */
void start () {
   primeiro = novaCelula(-1);
   ultimo = primeiro;
}


/**
 * Insere elemento na fila (politica FIFO).
 * @param x int Elemento a inserir.
 */
void inserir(int x) {
   ultimo->prox = novaCelula(x);
   ultimo = ultimo->prox;
}


/**
 * Remove elemento da fila (politica FIFO).
 * @return Elemento removido.
 */
int remover() {
   if (primeiro == ultimo) {
      errx(1, "Erro ao remover!");
   }
   Celula* tmp = primeiro;
   primeiro = primeiro->prox;
   int resp = primeiro->elemento;
   tmp->prox = NULL;
   free(tmp);
   tmp = NULL;
   return resp;
}


/**
 * Mostra os elementos separados por espacos.
 */
void mostrar() {
   Celula* i;
   printf("[ ");
   for (i = primeiro->prox; i != NULL; i = i->prox) {
      printf("%d ", i->elemento);
   }
   printf("] \n");
}

/*-----------------------------------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------------------------------*/

//PILHA DINAMICA EM C
typedef struct Celula {
	int elemento;        // Elemento inserido na celula.
	struct Celula* prox; // Aponta a celula prox.
} Celula;

Celula* novaCelula(int elemento) {
   Celula* nova = (Celula*) malloc(sizeof(Celula));
   nova->elemento = elemento;
   nova->prox = NULL;
   return nova;
}

//PILHA PROPRIAMENTE DITA =======================================================
Celula* topo; // Sem celula cabeca.


/**
 * Cria uma fila sem elementos.
 */
void start () {
   topo = NULL;
}


/**
 * Insere elemento na pilha (politica FILO).
 * @param x int elemento a inserir.
 */
void inserir(int x) {
   Celula* tmp = novaCelula(x);
   tmp->prox = topo;
   topo = tmp;
   tmp = NULL;
}

/**
 * Remove elemento da pilha (politica FILO).
 * @return Elemento removido.
 */
int remover() {
   if (topo == NULL) {
      errx(1, "Erro ao remover!");
   }

   int resp = topo->elemento;
   Celula* tmp = topo;
   topo = topo->prox;
   tmp->prox = NULL;
   free(tmp);
   tmp = NULL;
   return resp;
}


/**
 * Mostra os elementos separados por espacos, comecando do topo.
 */
void mostrar() {
   Celula* i;
   printf("[");
   for(i = topo; i != NULL; i = i->prox) {
      printf("%d ,", i->elemento);
   }

   printf("] \n");
}