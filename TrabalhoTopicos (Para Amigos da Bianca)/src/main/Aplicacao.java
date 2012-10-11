package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import processo.Processo;
import processo.ProcessoAlvaraFuncionamento;
import processo.ProcessoIPTU;
import processo.ProcessoISS;
import processo.ProcessoPropagandaPublicidade;

import complementos.Assunto;
import complementos.Atos;
import complementos.Motivo_de_Encerramento;
import complementos.Pendencia;
import complementos.Situacao;
import complementos.Tramitacao;
import comum.Imovel;
import comum.Pessoa;

import documentos.Documento;
import documentos.DocumentoArrecadacao;
import excecoes.ImovelNaoEncontradoException;
import excecoes.PessoaNaoEncontradaException;
import excecoes.ProcessoNaoEncontradoException;

public class Aplicacao {

	// Variaveis que formata as datas
	private static SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat ss = new SimpleDateFormat("yyyy");
	// //////////////////////////////////////

	// Variaveis que são ultilizadas no main, Contador que gera automatico e o
	// Usuario que se logou
	private static int contadornumero = 1;
	private static String usuario;
	// ///////////////////////////////////// 

	// ArrayList que armazena objetos do tipo Pessoa e Imovel
	private static ArrayList<String> Locais_tramitações_Cadastradas = new ArrayList<String>();
	private static ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	private static ArrayList<Imovel> imoveis = new ArrayList<Imovel>();
	// /////////////////////////////////////

	// HashMap que armazena todos os processos
	private static HashMap<String, Processo> processos = new HashMap<String, Processo>();
	// /////////////////////////////////////

	// Variaveis que servem para ler tanto como Letras e Numeros
	private static Scanner numeros = new Scanner(System.in);
	private static Scanner letras = new Scanner(System.in);

	// /////////////////////////////////////

	// Onde roda a aplicação
	public static void main(String args[]) {

		Locais_tramitações_Cadastradas.add("SETOR TI");
		Locais_tramitações_Cadastradas.add("DIRETORIA");
		Locais_tramitações_Cadastradas.add("SUPORTE");
		Locais_tramitações_Cadastradas.add("RH");
		
		int opMenuPrincipal = 1;
		System.out.println("Nome do Usuario Logado: ");
		usuario = letras.nextLine();
		do {
			do {
				System.out.println("-------MENU PRINCIPAL--------");
				System.out.println("1- Menu de Pessoa");
				System.out.println("2- Menu de Processos");
				System.out.println("3- Menu de Imoveis");
				System.out.println("4- Sair");
				try {
					opMenuPrincipal = numeros.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Opcao invalida (" + numeros.nextLine()
							+ ")");
					opMenuPrincipal = -1;
				}
			} while (opMenuPrincipal > 4 || opMenuPrincipal < 1);

			switch (opMenuPrincipal) {
			case 1:

				int opMenuPessoa;
				do {
					do {
						System.out.println("-------MENU DE PESSOA--------");
						System.out.println("1- Cadastrar Pessoa");
						System.out.println("2- Listar Pessoas");
						System.out.println("3- Excluir Pessoa");
						System.out.println("4- Voltar ao Menu Principal");
						try {
							opMenuPessoa = numeros.nextInt();
						} catch (InputMismatchException e) {
							System.out.println("Opcao invalida ("
									+ numeros.nextLine() + ")");
							opMenuPessoa = -1;
						}
					} while (opMenuPessoa > 4 || opMenuPessoa < 1);
					switch (opMenuPessoa) {
					case 1:
						CadastrarPessoa();
						break;

					case 2:
						ListarPessoas();
						break;

					case 3:
						ExcluirPessoa();
						break;

					case 4:
						break;

					default:
						System.out.println("Opcao Invalida!");
					}
				} while (opMenuPessoa != 4);

				break;

			case 2:

				int opMenuProcesso;
				do {
					do {
						System.out.println("-------MENU DE PROCESSO--------");
						System.out.println("1- Cadastrar Processo");
						System.out.println("2- Cadastrar Atos");
						System.out.println("3- Cadastrar Tramitacao");
						System.out.println("4- Cancelar Processo");
						System.out.println("5- Suspender Processo");
						System.out.println("6- Reativar Processo");
						System.out.println("7- Encerrar Processo");
						System.out.println("8- Retirar Pendencia");
						System.out.println("9- Imprimir Processo");
						System.out.println("10- Voltar ao Menu Principal");
						try {
							opMenuProcesso = numeros.nextInt();
						} catch (InputMismatchException e) {
							System.out.println("Opcao invalida ("
									+ numeros.nextLine() + ")");
							opMenuProcesso = -1;
						}
					} while (opMenuProcesso > 10 || opMenuProcesso < 1);

					switch (opMenuProcesso) {
					case 1:
						CadastrarProcesso();
						break;

					case 2:
						CadastrarAto();
						break;

					case 3:
						CadastrarTramitacao();
						break;

					case 4:
						CancelarProcesso();
						break;

					case 5:
						SuspenderProcesso();
						break;

					case 6:
						ReativarProcesso();
						break;

					case 7:
						EncerrarProcesso();
						break;

					case 8:
						RetirarPendencia();
						break;

					case 9:
						ImprimirProcesso();
						break;

					case 10:
						break;
					default:
						System.out.println("Opcao Invalida!");
					}
				} while (opMenuProcesso != 10);

				break;

			case 3:

				int opMenuImovel;
				do {
					do {
						System.out.println("-------MENU DE IMOVEIS--------");
						System.out.println("1- Cadastrar Imovel");
						System.out.println("2- Listar Imoveis");
						System.out.println("3- Buscar Imovel");
						System.out.println("4- Excluir Imovel");
						System.out.println("5- Voltar ao Menu Principal");
						try {
							opMenuImovel = numeros.nextInt();
						} catch (InputMismatchException e) {
							System.out.println("Opcao invalida ("
									+ numeros.nextLine() + ")");
							opMenuImovel = -1;
						}
					} while (opMenuImovel > 5 || opMenuImovel < 1);

					switch (opMenuImovel) {
					case 1:
						CadastrarImovel();
						break;

					case 2:
						ListarImoveis();
						break;

					case 3:
						BuscarImovel();
						break;

					case 4:
						ExcluirImovel();
						break;

					case 5:
						break;

					default:
						System.out.println("Opcao Invalida!");
					}
				} while (opMenuImovel != 5);

				break;

			case 4:
				break;

			default:
				System.out.println("Opcao Invalida!");
			}

		} while (opMenuPrincipal != 4);
	}

	// Método que Cadastra a Pessoa
	public static void CadastrarPessoa() {

		Pessoa pessoa = new Pessoa();

		System.out.println("-------CADASTRAR PESSOA--------");

		System.out.println("Digite o nome: ");
		String nome = letras.nextLine();
		pessoa.setNome(nome);

		System.out.println("Digite o CPF: ");
		String cpf = letras.nextLine();
		pessoa.setCpf(cpf);

		System.out.println("Digite o RG: ");
		String rg = letras.nextLine();
		pessoa.setRg(rg);

		System.out.println("Digite o Estado Civil: ");
		String estado_civil = letras.nextLine();
		pessoa.setEstado_civil(estado_civil);

		System.out.println("Digite o Endereco: ");
		String endereco = letras.nextLine();
		pessoa.setEndereco(endereco);

		System.out.println("Digite o Endereco de Correspondencia: ");
		String endereco_correspondencia = letras.nextLine();
		pessoa.setEndereco_correspondencia(endereco_correspondencia);

		System.out.println("Digite o Telefone: ");
		String telefone = letras.nextLine();
		pessoa.setTelefone(telefone);

		pessoas.add(pessoa);

		System.out.println("Cadastrado com Sucesso!");
		System.out.println("");
	}

	// ////////////////////////////////////

	// Método que Lista a Pessoas
	public static void ListarPessoas() {

		System.out.println("-------LISTAR PESSOAS--------");

		for (Pessoa p : pessoas) {
			System.out.println("Nome: " + p.getNome());
			System.out.println("CPF: " + p.getCpf());
			System.out.println("RG: " + p.getRg());
			System.out.println("Estado Civil: " + p.getEstado_civil());
			System.out.println("Endereco: " + p.getEndereco());
			System.out.println("Endereco para correspondencia: "
					+ p.getEndereco_correspondencia());
			System.out.println("Telefone: " + p.getTelefone());
			System.out.println("-----------------------------");
			System.out.println("");
		}
	}

	// ////////////////////////////////////

	// Método que Excluir a Pessoa
	public static void ExcluirPessoa() {

		System.out.println("-------EXCLUIR PESSOA--------");

		System.out.println("Digite o CPF da pessoa que deseja excluir: ");
		String CPFExcluir = letras.nextLine();
		System.out.println("Digite o nome da pessoa que deseja excluir: ");
		String nomeExcluir = letras.nextLine();

		int index;

		try {
			index = ProcurarPessoa(CPFExcluir, nomeExcluir);
			pessoas.remove(index);

			System.out.println("Excluido Com Sucesso!");
			System.out.println("");
		} catch (PessoaNaoEncontradaException e) {
			System.out.println("Pessoa Nao Encontrada!");
			System.out.println("");
		}
	}

	// ///////////////////////////////////

	// Método que Procurar a Pessoa
	public static int ProcurarPessoa(String CPF, String nome)
			throws PessoaNaoEncontradaException {

		for (int i = 0; i < pessoas.size(); i++) {
			if (pessoas.get(i).getCpf().equals(CPF)
					&& pessoas.get(i).getNome().equals(nome)) {
				return i;
			}
		}
		throw new PessoaNaoEncontradaException();
	}

	// ///////////////////////////////////

	// Método que Cadastra o Imovel
	public static void CadastrarImovel() {

		System.out.println("-------CADASTRAR IMOVEL--------");

		System.out.println("Digite o nome do dono: ");
		String nomedono = letras.nextLine();
		System.out.println("Digite o cpf do dono: ");
		String cpfdono = letras.nextLine();

		Pessoa pessoa = new Pessoa();
		Imovel imovel = new Imovel();

		try {
			int index = ProcurarPessoa(cpfdono, nomedono);
			pessoa = pessoas.get(index);
			imovel.setPessoa(pessoa);

			System.out.println("Digite o numero de inscricao: ");
			int numero_inscricao = numeros.nextInt();
			imovel.setNumero_inscricao(numero_inscricao);

			System.out.println("Digite o endereco: ");
			String endereco = letras.nextLine();
			imovel.setEndereço(endereco);

			System.out.println("Digite o bairro: ");
			String bairro = letras.nextLine();
			imovel.setBairro(bairro);

			System.out.println("Digite o numero: ");
			int numero = numeros.nextInt();
			imovel.setNumero(numero);

			imoveis.add(imovel);

			System.out.println("Cadastrado com Sucesso!");
			System.out.println("");
		} catch (PessoaNaoEncontradaException e) {
			System.out.println("Pessoa nao Encontrada!");
			System.out.println("");
		}
	}

	// //////////////////////////////////

	// Método que Listar o Imovel
	public static void ListarImoveis() {

		System.out.println("-------LISTAR IMOVEIS--------");

		for (Imovel i : imoveis) {
			System.out.println("Nome do dono: " + i.getPessoa().getNome());
			System.out.println("CPF do dono: " + i.getPessoa().getCpf());
			System.out.println("Endereco: " + i.getEndereço());
			System.out.println("Bairro: " + i.getBairro());
			System.out.println("Numero: " + i.getNumero());
			System.out.println("-----------------------------");
			System.out.println("");
		}
	}

	// /////////////////////////////////

	// Método que Buscar o Imovel
	public static void BuscarImovel() {

		System.out.println("-------BUSCAR IMOVEIS--------");

		System.out.println("Digite o numero da inscricao do imovel: ");
		int num_insc_busca = numeros.nextInt();

		int index;

		try {
			index = ProcurarImovel(num_insc_busca);
			System.out.println("Nome do Dono: "
					+ imoveis.get(index).getPessoa().getNome());
			System.out.println("CPF do Dono: "
					+ imoveis.get(index).getPessoa().getCpf());
			System.out.println("Numero Inscricao: "
					+ imoveis.get(index).getNumero_inscricao());
			System.out.println("Endereco: " + imoveis.get(index).getEndereço());
			System.out.println("Numero: " + imoveis.get(index).getNumero());
			System.out.println("Bairro: " + imoveis.get(index).getBairro());
			System.out.println("");
		} catch (ImovelNaoEncontradoException e) {
			System.out.println("Imovel Nao Encontrado!");
			System.out.println("");
		}
	}

	// /////////////////////////////////

	// Método que Excluir o Imovel
	public static void ExcluirImovel() {

		System.out.println("-------EXCLUIR IMOVEL--------");

		System.out.println("Digite o numero de inscricao do imovel: ");
		int num_insc_excluir = numeros.nextInt();

		int index;

		try {
			index = ProcurarImovel(num_insc_excluir);
			imoveis.remove(index);

			System.out.println("Excluido com Sucesso!");
			System.out.println("");
		} catch (ImovelNaoEncontradoException e) {
			System.out.println("Imovel Nao Encontrado!");
			System.out.println("");
		}
	}

	// /////////////////////////////////

	// Método que Procurar o Imovel
	public static int ProcurarImovel(int numero_inscricao)
			throws ImovelNaoEncontradoException {

		for (int i = 0; i < imoveis.size(); i++) {
			if (imoveis.get(i).getNumero_inscricao() == numero_inscricao) {
				return i;
			}
		}
		throw new ImovelNaoEncontradoException();
	}

	// ////////////////////////////////

	// Método que Cadastra os Processos
	public static void CadastrarProcesso() {

		int opCadastrarProcesso;

		do {
			System.out.println("-------CADASTRAR PROCESSO--------");
			System.out.println("1- Processo de IPTU");
			System.out.println("2- Processo de ISS");
			System.out.println("3- Processo de Alvara de Funcionamento");
			System.out.println("4- Processo de Propaganda e Publicidade");
			System.out.println("5- Voltar ao Menu de Processo");

			opCadastrarProcesso = numeros.nextInt();

			switch (opCadastrarProcesso) {
			case 1:

				System.out.println("-------CADASTRAR PROCESSO DE IPTU--------");

				System.out.println("Nome da Pessoa: ");
				String nomepessoa = letras.nextLine();
				System.out.println("CPF da Pessoa: ");
				String cpfpessoa = letras.nextLine();

				ProcessoIPTU processoIptu = new ProcessoIPTU();

				int index;

				try {
					index = ProcurarPessoa(cpfpessoa, nomepessoa);

					System.out.println("Informe a descricao do processo: ");
					String descricao = letras.nextLine();
					System.out.println("Informe a Inscricao do imovel: ");
					int insc_imovel = numeros.nextInt();

					try {
						Assunto assunto = new Assunto();
						DocumentoArrecadacao documentoArrecadacao = new DocumentoArrecadacao();
						ProcurarImovel(insc_imovel);

						System.out.println("Informe o assunto: ");
						String descricao_assunto = letras.nextLine();
						assunto.setDescricao(descricao_assunto);
						System.out
								.println("Existe taxa requerida? \n 1- SIM  2- NAO");
						int taxa = numeros.nextInt();

						documentoArrecadacao.setIndPago(true);

						if (taxa == 1) {
							assunto.setIndTaxa(true);
							System.out
									.println("Informe o numero do documento de arrecadacao: ");
							int numero_arrecacadacao = numeros.nextInt();
							documentoArrecadacao
									.setNumero(numero_arrecacadacao);
							System.out
									.println("O documento esta pago?  \n 1- SIM  2- NAO");
							int pago = numeros.nextInt();

							if (pago == 1) {
								documentoArrecadacao.setIndPago(true);
								ArrayList<Documento> DocumentoObg = new ArrayList<Documento>();
								ArrayList<Documento> DocumentoOpc = new ArrayList<Documento>();
								Documento documento = new Documento();

								int opDocObg;
								do {
									System.out
											.println("Digite a Sigla do Documento Obrigatorio: ");
									String sigla = letras.nextLine();
									System.out
											.println("Digite o Nome do Documento Obrigatorio: ");
									String nome = letras.nextLine();
									System.out
											.println("Deseja Adicionar outro documento? \n 1- SIM 2- NAO");
									opDocObg = numeros.nextInt();

									documento.setSigla(sigla);
									documento.setNome(nome);

									DocumentoObg.add(documento);

								} while (opDocObg == 1);

								System.out
										.println("Existe Documento Opcional? \n 1- SIM 2- NAO");

								int opDocOpc = numeros.nextInt();
								while (opDocOpc == 1) {
									System.out
											.println("Digite a Sigla do Documento Opcional: ");
									String sigla = letras.nextLine();
									System.out
											.println("Digite o Nome do Documento Opcional: ");
									String nome = letras.nextLine();
									System.out
											.println("Deseja Adicionar outro documento? \n 1- SIM 2- NAO");
									opDocOpc = numeros.nextInt();

									documento.setSigla(sigla);
									documento.setNome(nome);

									DocumentoOpc.add(documento);
								}

								Situacao situacao = new Situacao();
								situacao.setSituacao("ABERTO");
								situacao.setDataInicio(s.format(new Date()));
								situacao.setDataFim("__/__/____");
								ArrayList<Situacao> situacoes = new ArrayList<Situacao>();
								situacoes.add(situacao);

								processoIptu.setAssunto(assunto);
								processoIptu.setAtos(null);
								processoIptu.setDataAbertura(new Date());
								processoIptu.setDescricao(descricao);
								processoIptu
										.setDocArrecadacao(documentoArrecadacao);
								processoIptu.setDocumentosEntrOpc(DocumentoOpc);
								processoIptu
										.setDocumentosObrigatorios(DocumentoObg);
								processoIptu.setInscricao_imovel(insc_imovel);
								processoIptu.setNumeroAno(contadornumero + "/"
										+ ss.format(new Date()));
								processoIptu.setPendencias(null);
								processoIptu.setPessoa(pessoas.get(index));
								processoIptu.setSituacao(situacoes);
								processoIptu.setTramitacao(null);
								processoIptu.setUsuarioCadastro(usuario);

								processos.put(processoIptu.getNumeroAno(),
										processoIptu);
								contadornumero++;

							} else {
								Pendencia pendencia = new Pendencia();
								ArrayList<Documento> DocumentoObg = new ArrayList<Documento>();
								ArrayList<Documento> DocumentoOpc = new ArrayList<Documento>();
								Documento documento = new Documento();
								documentoArrecadacao.setIndPago(false);
								System.out
										.println("Informe a Descricao da Pendencia: ");
								String descricaoPendencia = letras.nextLine();
								pendencia.setDescricao(descricaoPendencia);
								try {
									pendencia.setDataPendencia(s.parse(s
											.format(new Date())));
								} catch (ParseException e) {
									System.out.println("Erro na Data.");
								}
								pendencia.setDataRegularizacao(null);

								int opDocObg;
								do {
									System.out
											.println("Digite a Sigla do Documento Obrigatorio: ");
									String sigla = letras.nextLine();
									System.out
											.println("Digite o Nome do Documento Obrigatorio: ");
									String nome = letras.nextLine();
									System.out
											.println("Deseja Adicionar outro documento? \n 1- SIM 2- NAO");
									opDocObg = numeros.nextInt();

									documento.setSigla(sigla);
									documento.setNome(nome);

									DocumentoObg.add(documento);
								} while (opDocObg == 1);

								System.out
										.println("Existe Documento Opcional? \n 1- SIM 2- NAO");
								int opDocOpc = numeros.nextInt();

								while (opDocOpc == 1) {
									System.out
											.println("Digite a Sigla do Documento Opcional: ");
									String sigla = letras.nextLine();
									System.out
											.println("Digite o Nome do Documento Opcional: ");
									String nome = letras.nextLine();
									System.out
											.println("Deseja Adicionar outro documento? \n 1- SIM 2- NAO");
									opDocOpc = numeros.nextInt();

									documento.setSigla(sigla);
									documento.setNome(nome);

									DocumentoOpc.add(documento);
								}

								Situacao situacao = new Situacao();
								situacao.setSituacao("ABERTO");
								situacao.setDataInicio(s.format(new Date()));
								situacao.setDataFim("__/__/____");
								ArrayList<Situacao> situacoes = new ArrayList<Situacao>();
								situacoes.add(situacao);

								processoIptu.setAssunto(assunto);
								processoIptu.setAtos(null);
								processoIptu.setDataAbertura(new Date());
								processoIptu.setDescricao(descricao);
								processoIptu
										.setDocArrecadacao(documentoArrecadacao);
								processoIptu.setDocumentosEntrOpc(DocumentoOpc);
								processoIptu
										.setDocumentosObrigatorios(DocumentoObg);
								processoIptu.setInscricao_imovel(insc_imovel);
								processoIptu.setNumeroAno(contadornumero + "/"
										+ ss.format(new Date()));
								processoIptu.setPendencias(pendencia);
								processoIptu.setPessoa(pessoas.get(index));
								processoIptu.setSituacao(situacoes);
								processoIptu.setTramitacao(null);
								processoIptu.setUsuarioCadastro(usuario);

								processos.put(processoIptu.getNumeroAno(),
										processoIptu);
								contadornumero++;
							}
						} else {
							ArrayList<Documento> DocumentoObg = new ArrayList<Documento>();
							ArrayList<Documento> DocumentoOpc = new ArrayList<Documento>();
							Documento documento = new Documento();
							assunto.setIndTaxa(false);

							System.out.println("");

							int opDocObg;
							do {
								System.out
										.println("Digite a Sigla do Documento Obrigatorio: ");
								String sigla = letras.nextLine();
								System.out
										.println("Digite o Nome do Documento Obrigatorio: ");
								String nome = letras.nextLine();
								System.out
										.println("Deseja Adicionar outro documento? \n 1- SIM 2- NAO");
								opDocObg = numeros.nextInt();

								documento.setSigla(sigla);
								documento.setNome(nome);

								DocumentoObg.add(documento);
							} while (opDocObg == 1);

							System.out
									.println("Existe Documento Opcional? \n 1- SIM 2- NAO");
							int opDocOpc = numeros.nextInt();

							while (opDocOpc == 1) {
								System.out
										.println("Digite a Sigla do Documento Opcional: ");
								String sigla = letras.nextLine();
								System.out
										.println("Digite o Nome do Documento Opcional: ");
								String nome = letras.nextLine();
								System.out
										.println("Deseja Adicionar outro documento? \n 1- SIM 2- NAO");
								opDocOpc = numeros.nextInt();

								documento.setSigla(sigla);
								documento.setNome(nome);

								DocumentoOpc.add(documento);
							}

							Situacao situacao = new Situacao();
							situacao.setSituacao("ABERTO");
							situacao.setDataInicio(s.format(new Date()));
							situacao.setDataFim("__/__/____");
							ArrayList<Situacao> situacoes = new ArrayList<Situacao>();
							situacoes.add(situacao);

							processoIptu.setAssunto(assunto);
							processoIptu.setAtos(null);
							processoIptu.setDataAbertura(new Date());
							processoIptu.setDescricao(descricao);
							processoIptu
									.setDocArrecadacao(documentoArrecadacao);
							processoIptu.setDocumentosEntrOpc(DocumentoOpc);
							processoIptu
									.setDocumentosObrigatorios(DocumentoObg);
							processoIptu.setInscricao_imovel(insc_imovel);
							processoIptu.setNumeroAno(contadornumero + "/"
									+ ss.format(new Date()));
							processoIptu.setPendencias(null);
							processoIptu.setPessoa(pessoas.get(index));
							processoIptu.setSituacao(situacoes);
							processoIptu.setTramitacao(null);
							processoIptu.setUsuarioCadastro(usuario);

							processos.put(processoIptu.getNumeroAno(),
									processoIptu);
							contadornumero++;
						}
					} catch (ImovelNaoEncontradoException e1) {
						System.out.println("Imovel Nao Encontrado!");
						System.out.println("");
					}

				} catch (PessoaNaoEncontradaException e) {
					System.out.println("Pessoa Nao Encontrada!");
					System.out.println("");
				}

				break;

			case 2:

				System.out.println("-------CADASTRAR PROCESSO DE ISS--------");

				System.out.println("Nome da Pessoa: ");
				String nomepessoa1 = letras.nextLine();
				System.out.println("CPF da Pessoa: ");
				String cpfpessoa1 = letras.nextLine();

				ProcessoISS processoIss = new ProcessoISS();

				int index1;

				try {
					index1 = ProcurarPessoa(cpfpessoa1, nomepessoa1);
					Assunto assunto = new Assunto();
					DocumentoArrecadacao documentoArrecadacao = new DocumentoArrecadacao();

					System.out.println("Informe a descricao do processo: ");
					String descricao = letras.nextLine();

					System.out.println("Informe a Inscricao do ISS: ");
					int insc_iss = numeros.nextInt();

					System.out.println("Informe o assunto: ");
					String descricao_assunto = letras.nextLine();
					assunto.setDescricao(descricao_assunto);

					System.out
							.println("Existe taxa requerida? \n 1- SIM  2- NAO");
					int taxa = numeros.nextInt();

					documentoArrecadacao.setIndPago(true);

					if (taxa == 1) {
						assunto.setIndTaxa(true);
						System.out
								.println("Informe o numero do documento de arrecadacao: ");
						int numero_arrecacadacao = numeros.nextInt();
						documentoArrecadacao.setNumero(numero_arrecacadacao);

						System.out
								.println("O documento esta pago?  \n 1- SIM  2- NAO");
						int pago = numeros.nextInt();

						if (pago == 1) {
							documentoArrecadacao.setIndPago(true);
							ArrayList<Documento> DocumentoObg = new ArrayList<Documento>();
							ArrayList<Documento> DocumentoOpc = new ArrayList<Documento>();
							Documento documento = new Documento();

							int opDocObg;

							do {
								System.out
										.println("Digite a Sigla do Documento Obrigatorio: ");
								String sigla = letras.nextLine();
								System.out
										.println("Digite o Nome do Documento Obrigatorio: ");
								String nome = letras.nextLine();
								System.out
										.println("Deseja Adicionar outro documento? \n 1- SIM 2- NAO");
								opDocObg = numeros.nextInt();

								documento.setSigla(sigla);
								documento.setNome(nome);

								DocumentoObg.add(documento);
							} while (opDocObg == 1);

							System.out
									.println("Existe Documento Opcional? \n 1- SIM 2- NAO");
							int opDocOpc = numeros.nextInt();
							while (opDocOpc == 1) {
								System.out
										.println("Digite a Sigla do Documento Opcional: ");
								String sigla = letras.nextLine();
								System.out
										.println("Digite o Nome do Documento Opcional: ");
								String nome = letras.nextLine();
								System.out
										.println("Deseja Adicionar outro documento? \n 1- SIM 2- NAO");
								opDocOpc = numeros.nextInt();

								documento.setSigla(sigla);
								documento.setNome(nome);

								DocumentoOpc.add(documento);
							}

							Situacao situacao = new Situacao();
							situacao.setSituacao("ABERTO");
							situacao.setDataInicio(s.format(new Date()));
							situacao.setDataFim("__/__/____");
							ArrayList<Situacao> situacoes = new ArrayList<Situacao>();
							situacoes.add(situacao);

							processoIss.setAssunto(assunto);
							processoIss.setAtos(null);
							processoIss.setDataAbertura(new Date());
							processoIss.setDescricao(descricao);
							processoIss.setDocArrecadacao(documentoArrecadacao);
							processoIss.setDocumentosEntrOpc(DocumentoOpc);
							processoIss.setDocumentosObrigatorios(DocumentoObg);
							processoIss.setInscricaoISS(insc_iss);
							processoIss.setNumeroAno(contadornumero + "/"
									+ ss.format(new Date()));
							processoIss.setPendencias(null);
							processoIss.setPessoa(pessoas.get(index1));
							processoIss.setSituacao(situacoes);
							processoIss.setTramitacao(null);
							processoIss.setUsuarioCadastro(usuario);

							processos.put(processoIss.getNumeroAno(),
									processoIss);
							contadornumero++;

						} else {
							Pendencia pendencia = new Pendencia();
							ArrayList<Documento> DocumentoObg = new ArrayList<Documento>();
							ArrayList<Documento> DocumentoOpc = new ArrayList<Documento>();
							Documento documento = new Documento();
							documentoArrecadacao.setIndPago(false);

							System.out
									.println("Informe a Descricao da Pendencia: ");
							String descricaoPendencia = letras.nextLine();
							pendencia.setDescricao(descricaoPendencia);
							try {
								pendencia.setDataPendencia(s.parse(s
										.format(new Date())));
							} catch (ParseException e) {
								System.out.println("Data Inválida.");
							}
							pendencia.setDataRegularizacao(null);

							int opDocObg;

							do {
								System.out
										.println("Digite a Sigla do Documento Obrigatorio: ");
								String sigla = letras.nextLine();
								System.out
										.println("Digite o Nome do Documento Obrigatorio: ");
								String nome = letras.nextLine();
								System.out
										.println("Deseja Adicionar outro documento? \n 1- SIM 2- NAO");
								opDocObg = numeros.nextInt();

								documento.setSigla(sigla);
								documento.setNome(nome);

								DocumentoObg.add(documento);
							} while (opDocObg == 1);

							System.out
									.println("Existe Documento Opcional? \n 1- SIM 2- NAO");
							int opDocOpc = numeros.nextInt();

							while (opDocOpc == 1) {
								System.out
										.println("Digite a Sigla do Documento Opcional: ");
								String sigla = letras.nextLine();
								System.out
										.println("Digite o Nome do Documento Opcional: ");
								String nome = letras.nextLine();
								System.out
										.println("Deseja Adicionar outro documento? \n 1- SIM 2- NAO");
								opDocOpc = numeros.nextInt();

								documento.setSigla(sigla);
								documento.setNome(nome);

								DocumentoOpc.add(documento);
							}

							Situacao situacao = new Situacao();
							situacao.setSituacao("ABERTO");
							situacao.setDataInicio(s.format(new Date()));
							situacao.setDataFim("__/__/____");
							ArrayList<Situacao> situacoes = new ArrayList<Situacao>();
							situacoes.add(situacao);

							processoIss.setAssunto(assunto);
							processoIss.setAtos(null);
							processoIss.setDataAbertura(new Date());
							processoIss.setDescricao(descricao);
							processoIss.setDocArrecadacao(documentoArrecadacao);
							processoIss.setDocumentosEntrOpc(DocumentoOpc);
							processoIss.setDocumentosObrigatorios(DocumentoObg);
							processoIss.setInscricaoISS(insc_iss);
							processoIss.setNumeroAno(contadornumero + "/"
									+ ss.format(new Date()));
							processoIss.setPendencias(pendencia);
							processoIss.setPessoa(pessoas.get(index1));
							processoIss.setSituacao(situacoes);
							processoIss.setTramitacao(null);
							processoIss.setUsuarioCadastro(usuario);

							processos.put(processoIss.getNumeroAno(),
									processoIss);
							contadornumero++;
						}
					} else {
						ArrayList<Documento> DocumentoObg = new ArrayList<Documento>();
						ArrayList<Documento> DocumentoOpc = new ArrayList<Documento>();
						Documento documento = new Documento();
						assunto.setIndTaxa(false);

						System.out.println("");

						int opDocObg;

						do {
							System.out
									.println("Digite a Sigla do Documento Obrigatorio: ");
							String sigla = letras.nextLine();
							System.out
									.println("Digite o Nome do Documento Obrigatorio: ");
							String nome = letras.nextLine();
							System.out
									.println("Deseja Adicionar outro documento? \n 1- SIM 2- NAO");
							opDocObg = numeros.nextInt();

							documento.setSigla(sigla);
							documento.setNome(nome);

							DocumentoObg.add(documento);
						} while (opDocObg == 1);

						System.out
								.println("Existe Documento Opcional? \n 1- SIM 2- NAO");
						int opDocOpc = numeros.nextInt();

						while (opDocOpc == 1) {
							System.out
									.println("Digite a Sigla do Documento Opcional: ");
							String sigla = letras.nextLine();
							System.out
									.println("Digite o Nome do Documento Opcional: ");
							String nome = letras.nextLine();
							System.out
									.println("Deseja Adicionar outro documento? \n 1- SIM 2- NAO");
							opDocOpc = numeros.nextInt();

							documento.setSigla(sigla);
							documento.setNome(nome);

							DocumentoOpc.add(documento);
						}
						Situacao situacao = new Situacao();

						situacao.setSituacao("ABERTO");
						situacao.setDataInicio(s.format(new Date()));
						situacao.setDataFim("__/__/____");
						ArrayList<Situacao> situacoes = new ArrayList<Situacao>();
						situacoes.add(situacao);

						processoIss.setAssunto(assunto);
						processoIss.setAtos(null);
						processoIss.setDataAbertura(new Date());
						processoIss.setDescricao(descricao);
						processoIss.setDocArrecadacao(documentoArrecadacao);
						processoIss.setDocumentosEntrOpc(DocumentoOpc);
						processoIss.setDocumentosObrigatorios(DocumentoObg);
						processoIss.setInscricaoISS(insc_iss);
						processoIss.setNumeroAno(contadornumero + "/"
								+ ss.format(new Date()));
						processoIss.setPendencias(null);
						processoIss.setPessoa(pessoas.get(index1));
						processoIss.setSituacao(situacoes);
						processoIss.setTramitacao(null);
						processoIss.setUsuarioCadastro(usuario);

						processos.put(processoIss.getNumeroAno(), processoIss);
						contadornumero++;
					}
				} catch (PessoaNaoEncontradaException e) {
					System.out.println("Pessoa Nao Encontrada!");
					System.out.println("");
				}

				break;

			case 3:

				System.out
						.println("-------CADASTRAR PROCESSO DE ALVARA DE FUNCIONAMENTO--------");

				System.out.println("Nome da Pessoa: ");
				String nomepessoa2 = letras.nextLine();
				System.out.println("CPF da Pessoa: ");
				String cpfpessoa2 = letras.nextLine();

				ProcessoAlvaraFuncionamento processoAF = new ProcessoAlvaraFuncionamento();

				int index2;

				try {
					index2 = ProcurarPessoa(cpfpessoa2, nomepessoa2);

					System.out.println("Informe a descricao do processo: ");
					String descricao = letras.nextLine();

					System.out.println("Informe a Inscricao do imovel: ");
					int insc_imovel = numeros.nextInt();

					try {
						Assunto assunto = new Assunto();
						DocumentoArrecadacao documentoArrecadacao = new DocumentoArrecadacao();
						ProcurarImovel(insc_imovel);

						System.out.println("Informe a area do imovel: ");
						int area_imovel = numeros.nextInt();

						System.out
								.println("Informe o codigo da atividade da empresa: ");
						int atividade_empresa = numeros.nextInt();

						System.out.println("Informe o assunto: ");
						String descricao_assunto = letras.nextLine();
						assunto.setDescricao(descricao_assunto);

						System.out
								.println("Existe taxa requerida? \n 1- SIM  2- NAO");
						int taxa = numeros.nextInt();

						documentoArrecadacao.setIndPago(true);

						if (taxa == 1) {
							assunto.setIndTaxa(true);

							System.out
									.println("Informe o numero do documento de arrecadacao: ");
							int numero_arrecacadacao = numeros.nextInt();
							documentoArrecadacao
									.setNumero(numero_arrecacadacao);

							System.out
									.println("O documento esta pago?  \n 1- SIM  2- NAO");
							int pago = numeros.nextInt();

							if (pago == 1) {
								ArrayList<Documento> DocumentoObg = new ArrayList<Documento>();
								ArrayList<Documento> DocumentoOpc = new ArrayList<Documento>();
								Documento documento = new Documento();
								documentoArrecadacao.setIndPago(true);

								int opDocObg;

								do {
									System.out
											.println("Digite a Sigla do Documento Obrigatorio: ");
									String sigla = letras.nextLine();
									System.out
											.println("Digite o Nome do Documento Obrigatorio: ");
									String nome = letras.nextLine();
									System.out
											.println("Deseja Adicionar outro documento? \n 1- SIM 2- NAO");
									opDocObg = numeros.nextInt();

									documento.setSigla(sigla);
									documento.setNome(nome);

									DocumentoObg.add(documento);
								} while (opDocObg == 1);

								System.out
										.println("Existe Documento Opcional? \n 1- SIM 2- NAO");
								int opDocOpc = numeros.nextInt();

								while (opDocOpc == 1) {

									System.out
											.println("Digite a Sigla do Documento Opcional: ");
									String sigla = letras.nextLine();
									System.out
											.println("Digite o Nome do Documento Opcional: ");
									String nome = letras.nextLine();
									System.out
											.println("Deseja Adicionar outro documento? \n 1- SIM 2- NAO");
									opDocOpc = numeros.nextInt();

									documento.setSigla(sigla);
									documento.setNome(nome);

									DocumentoOpc.add(documento);
								}

								Situacao situacao = new Situacao();
								situacao.setSituacao("ABERTO");
								situacao.setDataInicio(s.format(new Date()));
								situacao.setDataFim("__/__/____");
								ArrayList<Situacao> situacoes = new ArrayList<Situacao>();
								situacoes.add(situacao);

								processoAF.setAssunto(assunto);
								processoAF.setAtos(null);
								processoAF.setDataAbertura(new Date());
								processoAF.setDescricao(descricao);
								processoAF
										.setDocArrecadacao(documentoArrecadacao);
								processoAF.setDocumentosEntrOpc(DocumentoOpc);
								processoAF
										.setDocumentosObrigatorios(DocumentoObg);
								processoAF.setInscricaoImovel(insc_imovel);
								processoAF.setAreaImovel(area_imovel);
								processoAF.setCodigo(atividade_empresa);
								processoAF.setNumeroAno(contadornumero + "/"
										+ ss.format(new Date()));
								processoAF.setPendencias(null);
								processoAF.setPessoa(pessoas.get(index2));
								processoAF.setSituacao(situacoes);
								processoAF.setTramitacao(null);
								processoAF.setUsuarioCadastro(usuario);

								processos.put(processoAF.getNumeroAno(),
										processoAF);
								contadornumero++;
							} else {
								Pendencia pendencia = new Pendencia();
								documentoArrecadacao.setIndPago(false);
								ArrayList<Documento> DocumentoObg = new ArrayList<Documento>();
								ArrayList<Documento> DocumentoOpc = new ArrayList<Documento>();
								Documento documento = new Documento();

								System.out
										.println("Informe a Descricao da Pendencia: ");
								String descricaoPendencia = letras.nextLine();
								pendencia.setDescricao(descricaoPendencia);
								try {
									pendencia.setDataPendencia(s.parse(s
											.format(new Date())));
								} catch (ParseException e) {
									System.out.println("Data Inválida.");
								}
								pendencia.setDataRegularizacao(null);

								int opDocObg;

								do {
									System.out
											.println("Digite a Sigla do Documento Obrigatorio: ");
									String sigla = letras.nextLine();
									System.out
											.println("Digite o Nome do Documento Obrigatorio: ");
									String nome = letras.nextLine();
									System.out
											.println("Deseja Adicionar outro documento? \n 1- SIM 2- NAO");
									opDocObg = numeros.nextInt();

									documento.setSigla(sigla);
									documento.setNome(nome);

									DocumentoObg.add(documento);
								} while (opDocObg == 1);

								System.out
										.println("Existe Documento Opcional? \n 1- SIM 2- NAO");
								int opDocOpc = numeros.nextInt();

								while (opDocOpc == 1) {
									System.out
											.println("Digite a Sigla do Documento Opcional: ");
									String sigla = letras.nextLine();
									System.out
											.println("Digite o Nome do Documento Opcional: ");
									String nome = letras.nextLine();
									System.out
											.println("Deseja Adicionar outro documento? \n 1- SIM 2- NAO");
									opDocOpc = numeros.nextInt();

									documento.setSigla(sigla);
									documento.setNome(nome);

									DocumentoOpc.add(documento);
								}

								Situacao situacao = new Situacao();
								situacao.setSituacao("ABERTO");
								situacao.setDataInicio(s.format(new Date()));
								situacao.setDataFim("__/__/____");
								ArrayList<Situacao> situacoes = new ArrayList<Situacao>();
								situacoes.add(situacao);

								processoAF.setAssunto(assunto);
								processoAF.setAtos(null);
								processoAF.setDataAbertura(new Date());
								processoAF.setDescricao(descricao);
								processoAF
										.setDocArrecadacao(documentoArrecadacao);
								processoAF.setDocumentosEntrOpc(DocumentoOpc);
								processoAF
										.setDocumentosObrigatorios(DocumentoObg);
								processoAF.setInscricaoImovel(insc_imovel);
								processoAF.setAreaImovel(area_imovel);
								processoAF.setCodigo(atividade_empresa);
								processoAF.setNumeroAno(contadornumero + "/"
										+ ss.format(new Date()));
								processoAF.setPendencias(null);
								processoAF.setPessoa(pessoas.get(index2));
								processoAF.setSituacao(situacoes);
								processoAF.setTramitacao(null);
								processoAF.setUsuarioCadastro(usuario);

								processos.put(processoAF.getNumeroAno(),
										processoAF);
								contadornumero++;
							}
						} else {

							ArrayList<Documento> DocumentoObg = new ArrayList<Documento>();
							ArrayList<Documento> DocumentoOpc = new ArrayList<Documento>();
							Documento documento = new Documento();
							assunto.setIndTaxa(false);

							System.out.println("");

							int opDocObg;

							do {
								System.out
										.println("Digite a Sigla do Documento Obrigatorio: ");
								String sigla = letras.nextLine();
								System.out
										.println("Digite o Nome do Documento Obrigatorio: ");
								String nome = letras.nextLine();
								System.out
										.println("Deseja Adicionar outro documento? \n 1- SIM 2- NAO");
								opDocObg = numeros.nextInt();

								documento.setSigla(sigla);
								documento.setNome(nome);

								DocumentoObg.add(documento);
							} while (opDocObg == 1);

							System.out
									.println("Existe Documento Opcional? \n 1- SIM 2- NAO");
							int opDocOpc = numeros.nextInt();

							while (opDocOpc == 1) {
								System.out
										.println("Digite a Sigla do Documento Opcional: ");
								String sigla = letras.nextLine();
								System.out
										.println("Digite o Nome do Documento Opcional: ");
								String nome = letras.nextLine();
								System.out
										.println("Deseja Adicionar outro documento? \n 1- SIM 2- NAO");
								opDocOpc = numeros.nextInt();

								documento.setSigla(sigla);
								documento.setNome(nome);

								DocumentoOpc.add(documento);
							}
							Situacao situacao = new Situacao();
							situacao.setSituacao("ABERTO");
							situacao.setDataInicio(s.format(new Date()));
							situacao.setDataFim("__/__/____");
							ArrayList<Situacao> situacoes = new ArrayList<Situacao>();
							situacoes.add(situacao);

							processoAF.setAssunto(assunto);
							processoAF.setAtos(null);
							processoAF.setDataAbertura(new Date());
							processoAF.setDescricao(descricao);
							processoAF.setDocArrecadacao(documentoArrecadacao);
							processoAF.setDocumentosEntrOpc(DocumentoOpc);
							processoAF.setDocumentosObrigatorios(DocumentoObg);
							processoAF.setInscricaoImovel(insc_imovel);
							processoAF.setAreaImovel(area_imovel);
							processoAF.setCodigo(atividade_empresa);
							processoAF.setNumeroAno(contadornumero + "/"
									+ ss.format(new Date()));
							processoAF.setPendencias(null);
							processoAF.setPessoa(pessoas.get(index2));
							processoAF.setSituacao(situacoes);
							processoAF.setTramitacao(null);
							processoAF.setUsuarioCadastro(usuario);

							processos
									.put(processoAF.getNumeroAno(), processoAF);
							contadornumero++;
						}
					} catch (ImovelNaoEncontradoException e1) {
						System.out.println("Imovel Nao Encontrado!");
						System.out.println("");
					}
				} catch (PessoaNaoEncontradaException e) {
					System.out.println("Pessoa Nao Encontrada!");
					System.out.println("");
				}

				break;

			case 4:

				System.out
						.println("-------CADASTRAR PROCESSO DE PROPAGANDA E PUBLICIDADE--------");

				System.out.println("Nome da Pessoa: ");
				String nomepessoa3 = letras.nextLine();
				System.out.println("CPF da Pessoa: ");
				String cpfpessoa3 = letras.nextLine();

				ProcessoPropagandaPublicidade processoPP = new ProcessoPropagandaPublicidade();

				int index3;

				try {
					index3 = ProcurarPessoa(cpfpessoa3, nomepessoa3);
					Assunto assunto = new Assunto();
					DocumentoArrecadacao documentoArrecadacao = new DocumentoArrecadacao();

					System.out.println("Informe a descricao do processo: ");
					String descricao = letras.nextLine();

					System.out.println("Informe o tipo de Engenho: ");
					String tipo_engenho = letras.nextLine();

					System.out.println("Informe o endereco da placa: ");
					String endereco_placa = letras.nextLine();

					System.out.println("Informe a area da placa: ");
					int area_placa = numeros.nextInt();

					System.out.println("Informe o assunto: ");
					String descricao_assunto = letras.nextLine();
					assunto.setDescricao(descricao_assunto);

					System.out
							.println("Existe taxa requerida? \n 1- SIM  2- NAO");
					int taxa = numeros.nextInt();

					documentoArrecadacao.setIndPago(true);

					if (taxa == 1) {

						assunto.setIndTaxa(true);
						System.out
								.println("Informe o numero do documento de arrecadacao: ");
						int numero_arrecacadacao = numeros.nextInt();
						documentoArrecadacao.setNumero(numero_arrecacadacao);

						System.out
								.println("O documento esta pago?  \n 1- SIM  2- NAO");
						int pago = numeros.nextInt();

						if (pago == 1) {
							ArrayList<Documento> DocumentoObg = new ArrayList<Documento>();
							ArrayList<Documento> DocumentoOpc = new ArrayList<Documento>();
							Documento documento = new Documento();
							documentoArrecadacao.setIndPago(true);

							int opDocObg;

							do {
								System.out
										.println("Digite a Sigla do Documento Obrigatorio: ");
								String sigla = letras.nextLine();

								System.out
										.println("Digite o Nome do Documento Obrigatorio: ");
								String nome = letras.nextLine();

								System.out
										.println("Deseja Adicionar outro documento? \n 1- SIM 2- NAO");
								opDocObg = numeros.nextInt();

								documento.setSigla(sigla);
								documento.setNome(nome);

								DocumentoObg.add(documento);
							} while (opDocObg == 1);

							System.out
									.println("Existe Documento Opcional? \n 1- SIM 2- NAO");
							int opDocOpc = numeros.nextInt();

							while (opDocOpc == 1) {

								System.out
										.println("Digite a Sigla do Documento Opcional: ");
								String sigla = letras.nextLine();
								System.out
										.println("Digite o Nome do Documento Opcional: ");
								String nome = letras.nextLine();
								System.out
										.println("Deseja Adicionar outro documento? \n 1- SIM 2- NAO");
								opDocOpc = numeros.nextInt();

								documento.setSigla(sigla);
								documento.setNome(nome);

								DocumentoOpc.add(documento);
							}

							Situacao situacao = new Situacao();
							situacao.setSituacao("ABERTO");
							situacao.setDataInicio(s.format(new Date()));
							situacao.setDataFim("__/__/____");
							ArrayList<Situacao> situacoes = new ArrayList<Situacao>();
							situacoes.add(situacao);

							processoPP.setAssunto(assunto);
							processoPP.setAtos(null);
							processoPP.setDataAbertura(new Date());
							processoPP.setDescricao(descricao);
							processoPP.setDocArrecadacao(documentoArrecadacao);
							processoPP.setDocumentosEntrOpc(DocumentoOpc);
							processoPP.setDocumentosObrigatorios(DocumentoObg);
							processoPP.setAreaPlaca(area_placa);
							processoPP.setEndereco(endereco_placa);
							processoPP.setTipoEngenho(tipo_engenho);
							processoPP.setNumeroAno(contadornumero + "/"
									+ ss.format(new Date()));
							processoPP.setPendencias(null);
							processoPP.setPessoa(pessoas.get(index3));
							processoPP.setSituacao(situacoes);
							processoPP.setTramitacao(null);
							processoPP.setUsuarioCadastro(usuario);

							processos
									.put(processoPP.getNumeroAno(), processoPP);
							contadornumero++;
						} else {
							ArrayList<Documento> DocumentoObg = new ArrayList<Documento>();
							ArrayList<Documento> DocumentoOpc = new ArrayList<Documento>();
							Documento documento = new Documento();
							Pendencia pendencia = new Pendencia();
							documentoArrecadacao.setIndPago(false);

							System.out
									.println("Informe a Descricao da Pendencia: ");
							String descricaoPendencia = letras.nextLine();
							pendencia.setDescricao(descricaoPendencia);

							try {
								pendencia.setDataPendencia(s.parse(s
										.format(new Date())));
							} catch (ParseException e) {
								System.out.println("Data Inválida.");
							}
							pendencia.setDataRegularizacao(null);

							int opDocObg;

							do {
								System.out
										.println("Digite a Sigla do Documento Obrigatorio: ");
								String sigla = letras.nextLine();
								System.out
										.println("Digite o Nome do Documento Obrigatorio: ");
								String nome = letras.nextLine();
								System.out
										.println("Deseja Adicionar outro documento? \n 1- SIM 2- NAO");
								opDocObg = numeros.nextInt();

								documento.setSigla(sigla);
								documento.setNome(nome);

								DocumentoObg.add(documento);
							} while (opDocObg == 1);

							System.out
									.println("Existe Documento Opcional? \n 1- SIM 2- NAO");
							int opDocOpc = numeros.nextInt();

							while (opDocOpc == 1) {
								System.out
										.println("Digite a Sigla do Documento Opcional: ");
								String sigla = letras.nextLine();
								System.out
										.println("Digite o Nome do Documento Opcional: ");
								String nome = letras.nextLine();
								System.out
										.println("Deseja Adicionar outro documento? \n 1- SIM 2- NAO");
								opDocOpc = numeros.nextInt();

								documento.setSigla(sigla);
								documento.setNome(nome);

								DocumentoOpc.add(documento);
							}
							Situacao situacao = new Situacao();
							situacao.setSituacao("ABERTO");
							situacao.setDataInicio(s.format(new Date()));
							situacao.setDataFim("__/__/____");
							ArrayList<Situacao> situacoes = new ArrayList<Situacao>();
							situacoes.add(situacao);

							processoPP.setAssunto(assunto);
							processoPP.setAtos(null);
							processoPP.setDataAbertura(new Date());
							processoPP.setDescricao(descricao);
							processoPP.setDocArrecadacao(documentoArrecadacao);
							processoPP.setDocumentosEntrOpc(DocumentoOpc);
							processoPP.setDocumentosObrigatorios(DocumentoObg);
							processoPP.setAreaPlaca(area_placa);
							processoPP.setEndereco(endereco_placa);
							processoPP.setTipoEngenho(tipo_engenho);
							processoPP.setNumeroAno(contadornumero + "/"
									+ ss.format(new Date()));
							processoPP.setPendencias(pendencia);
							processoPP.setPessoa(pessoas.get(index3));
							processoPP.setSituacao(situacoes);
							processoPP.setTramitacao(null);
							processoPP.setUsuarioCadastro(usuario);

							processos
									.put(processoPP.getNumeroAno(), processoPP);
							contadornumero++;
						}
					} else {
						assunto.setIndTaxa(false);
						ArrayList<Documento> DocumentoObg = new ArrayList<Documento>();
						ArrayList<Documento> DocumentoOpc = new ArrayList<Documento>();
						Documento documento = new Documento();

						System.out.println("");

						int opDocObg;

						do {
							System.out
									.println("Digite a Sigla do Documento Obrigatorio: ");
							String sigla = letras.nextLine();
							System.out
									.println("Digite o Nome do Documento Obrigatorio: ");
							String nome = letras.nextLine();
							System.out
									.println("Deseja Adicionar outro documento? \n 1- SIM 2- NAO");
							opDocObg = numeros.nextInt();

							documento.setSigla(sigla);
							documento.setNome(nome);

							DocumentoObg.add(documento);
						} while (opDocObg == 1);

						System.out
								.println("Existe Documento Opcional? \n 1- SIM 2- NAO");
						int opDocOpc = numeros.nextInt();

						while (opDocOpc == 1) {
							System.out
									.println("Digite a Sigla do Documento Opcional: ");
							String sigla = letras.nextLine();
							System.out
									.println("Digite o Nome do Documento Opcional: ");
							String nome = letras.nextLine();
							System.out
									.println("Deseja Adicionar outro documento? \n 1- SIM 2- NAO");
							opDocOpc = numeros.nextInt();

							documento.setSigla(sigla);
							documento.setNome(nome);

							DocumentoOpc.add(documento);
						}

						Situacao situacao = new Situacao();
						situacao.setSituacao("ABERTO");
						situacao.setDataInicio(s.format(new Date()));
						situacao.setDataFim("__/__/____");
						ArrayList<Situacao> situacoes = new ArrayList<Situacao>();
						situacoes.add(situacao);

						processoPP.setAssunto(assunto);
						processoPP.setAtos(null);
						processoPP.setDataAbertura(new Date());
						processoPP.setDescricao(descricao);
						processoPP.setDocArrecadacao(documentoArrecadacao);
						processoPP.setDocumentosEntrOpc(DocumentoOpc);
						processoPP.setDocumentosObrigatorios(DocumentoObg);
						processoPP.setAreaPlaca(area_placa);
						processoPP.setEndereco(endereco_placa);
						processoPP.setTipoEngenho(tipo_engenho);
						processoPP.setNumeroAno(contadornumero + "/"
								+ ss.format(new Date()));
						processoPP.setPendencias(null);
						processoPP.setPessoa(pessoas.get(index3));
						processoPP.setSituacao(situacoes);
						processoPP.setTramitacao(null);
						processoPP.setUsuarioCadastro(usuario);

						processos.put(processoPP.getNumeroAno(), processoPP);
						contadornumero++;
					}
				} catch (PessoaNaoEncontradaException e) {
					System.out.println("Pessoa Nao Encontrada!");
					System.out.println("");
				}

				break;
			}
		} while (opCadastrarProcesso != 5);
	}

	// ////////////////////////////////

	// Método que Cadastra as Tramitações
	public static void CadastrarTramitacao() {

		System.out.println("-------CADASTRAR TRAMITACAO--------");

		System.out.println("Qual o codigo do processo? (ex: 1/2011)");
		String cod = letras.nextLine();

		ArrayList<Tramitacao> Tramitacoes = new ArrayList<Tramitacao>();
		Tramitacao tramitacao = new Tramitacao();

		try {
			Processo processo = ProcurarProcesso(cod);

			if (processo.getDocArrecadacao().isIndPago() == true) {
				if (processo.getTramitacao() != null) {
					for (int i = 0; i < processo.getTramitacao().size(); i++) {
						Tramitacoes.add(processo.getTramitacao().get(i));
					}
				}

				System.out.println("Escolha o Local de Destino: ");
				for (int i = 0; i < Locais_tramitações_Cadastradas.size() ; i++) {
					System.out.println(i+1+"-"+Locais_tramitações_Cadastradas.get(i));
				}
				int local;
				do {
					local = numeros.nextInt();
				} while (local < 0 || local > Locais_tramitações_Cadastradas.size());
				local = local - 1;
				
				System.out.println("Digite o Usuario do Destino: ");
				String usuariodestino = letras.nextLine();
				System.out
						.println("Digite a Data de Recebimento: (ex:10/10/2010)");
				String data = letras.nextLine();

				tramitacao.setUsuarioReceb(usuariodestino);
				tramitacao.setUsuarioEnvio(usuario);
				tramitacao.setLocalDestino(Locais_tramitações_Cadastradas.get(local));

				try {
					tramitacao.setDataEnvio(s.parse(s.format(new Date())));
					tramitacao.setDataReceb(s.parse(data));
				} catch (ParseException e) {
					System.out.println("Data Inválida.");
				}

				Tramitacoes.add(tramitacao);

				processo.setTramitacao(Tramitacoes);
				processos.remove(cod);
				processos.put(cod, processo);
			} else {
				System.out
						.println("Documento com Pendencia, nao pode adicionar tramitacao!");
				System.out.println("");
			}
		} catch (ProcessoNaoEncontradoException e) {
			System.out.println("Processo Nao Encontrado!");
			System.out.println("");
		}
	}

	// ////////////////////////////////

	// Método que Cadastra os Atos
	public static void CadastrarAto() {

		System.out.println("-------CADASTRAR ATO--------");

		System.out.println("Qual o codigo do processo? (ex: 1/2011)");
		String cod = letras.nextLine();

		ArrayList<Atos> Atos = new ArrayList<Atos>();

		Atos ato = new Atos();

		try {
			Processo processo = ProcurarProcesso(cod);

			int opAtos;

			if (processo.getDocArrecadacao().isIndPago() == true) {
				if (processo.getAtos() != null) {
					for (int i = 0; i < processo.getAtos().size(); i++) {
						Atos.add(processo.getAtos().get(i));
					}
				}
				do {
					System.out.println("Digite a Descricao do Ato: ");
					String descricao = letras.nextLine();
					System.out
							.println("Deseja Adicionar outro Ato? \n 1- SIM 2- NAO");
					opAtos = numeros.nextInt();

					ato.setDescricao(descricao);

					try {
						ato.setData(s.parse(s.format(new Date())));
					} catch (ParseException e) {
						System.out.println("Data Inválida.");
					}

					ato.setUsuario(usuario);
					Atos.add(ato);
				} while (opAtos == 1);

				processo.setAtos(Atos);
				processos.remove(cod);
				processos.put(cod, processo);
			} else {
				System.out
						.println("Documento com Pendencia, nao pode adicionar ato!");
				System.out.println("");
			}
		} catch (ProcessoNaoEncontradoException e) {
			System.out.println("Processo Nao Encontrado!");
			System.out.println("");
		}
	}

	// ////////////////////////////////

	// Método que Procurar o Processo
	public static Processo ProcurarProcesso(String cod)
			throws ProcessoNaoEncontradoException {

		Processo processo = processos.get(cod);

		if (processo == null) {
			throw new ProcessoNaoEncontradoException();
		} else {
			return processo;
		}
	}

	// ////////////////////////////////

	// Método que Cancelar o Processo
	public static void CancelarProcesso() {

		System.out.println("-------CANCELAR PROCESSO--------");

		System.out.println("Qual o codigo do processo? (ex: 1/2011)");
		String cod = letras.nextLine();

		try {
			Processo processo = ProcurarProcesso(cod);
			Situacao situacao = new Situacao();
			ArrayList<Situacao> situacoes = new ArrayList<Situacao>();
			if (processo.getSituacao() != null) {
				for (int i = 0; i < processo.getSituacao().size(); i++) {
					situacao.setDataFim(processo.getSituacao().get(i)
							.getDataFim());
					situacao.setDataInicio(processo.getSituacao().get(i)
							.getDataInicio());
					situacao.setSituacao(processo.getSituacao().get(i)
							.getSituacao());
					situacoes.add(situacao);
				}
			}

			if (processo.getSituacao().get((processo.getSituacao().size() - 1))
					.getSituacao().equals("ABERTO")) {

				if (processo.getDocArrecadacao().isIndPago() == true) {
					Situacao situacao1 = new Situacao();

					situacoes.get(processo.getSituacao().size() - 1)
							.setDataFim(s.format(new Date()));
					situacao1.setSituacao("CANCELADO");
					situacao1.setDataInicio(s.format(new Date()));
					situacao1.setDataFim("__/__/____");
					situacoes.add(situacao1);

					processo.setSituacao(situacoes);
					processos.remove(cod);
					processos.put(cod, processo);

				} else {
					System.out
							.println("Processo com Pendencia, nao pode haver alteracao!");
					System.out.println("");
				}
			} else {
				System.out.println("Processo nao estar aberto!");
				System.out.println("");
			}
		} catch (ProcessoNaoEncontradoException e) {
			System.out.println("Processo Nao Encontrado!");
			System.out.println("");
		}
	}

	// ////////////////////////////////

	// Método que Suspender o Processo
	public static void SuspenderProcesso() {

		System.out.println("-------SUSPENDER PROCESSO--------");

		System.out.println("Qual o codigo do processo? (ex: 1/2011)");
		String cod = letras.nextLine();

		try {
			Processo processo = ProcurarProcesso(cod);
			Situacao situacao = new Situacao();
			ArrayList<Situacao> situacoes = new ArrayList<Situacao>();
			if (processo.getSituacao() != null) {
				for (int i = 0; i < processo.getSituacao().size(); i++) {
					situacao.setDataFim(processo.getSituacao().get(i)
							.getDataFim());
					situacao.setDataInicio(processo.getSituacao().get(i)
							.getDataInicio());
					situacao.setSituacao(processo.getSituacao().get(i)
							.getSituacao());
					situacoes.add(situacao);
				}
			}

			if (processo.getSituacao().get(processo.getSituacao().size() - 1)
					.getSituacao().equals("ABERTO")) {
				if (processo.getDocArrecadacao().isIndPago() == true) {
					Situacao situacao3 = new Situacao();

					situacoes.get(processo.getSituacao().size() - 1)
							.setDataFim(s.format(new Date()));
					situacao3.setSituacao("SUSPENSO");
					situacao3.setDataInicio(s.format(new Date()));
					situacao3.setDataFim("__/__/____");
					situacoes.add(situacao3);
					processo.setSituacao(situacoes);
					processos.remove(cod);
					processos.put(cod, processo);
				} else {
					System.out
							.println("Processo com Pendencia, nao pode haver alteracao!");
					System.out.println("");
				}
			} else {
				System.out.println("Processo nao estar aberto!");
				System.out.println("");
			}
		} catch (ProcessoNaoEncontradoException e) {
			System.out.println("Processo Nao Encontrado!");
			System.out.println("");
		}
	}

	// ////////////////////////////////

	// Método que Reativar o Processo
	public static void ReativarProcesso() {

		System.out.println("-------REATIVAR PROCESSO--------");

		System.out.println("Qual o codigo do processo? (ex: 1/2011)");
		String cod = letras.nextLine();

		try {
			Processo processo = ProcurarProcesso(cod);
			Situacao situacao = new Situacao();
			ArrayList<Situacao> situacoes = new ArrayList<Situacao>();

			if (processo.getSituacao() != null) {
				for (int i = 0; i < processo.getSituacao().size(); i++) {
					situacao.setDataFim(processo.getSituacao().get(i)
							.getDataFim());
					situacao.setDataInicio(processo.getSituacao().get(i)
							.getDataInicio());
					situacao.setSituacao(processo.getSituacao().get(i)
							.getSituacao());
					situacoes.add(situacao);
				}
			}

			if (processo.getSituacao().get(processo.getSituacao().size() - 1)
					.getSituacao().equals("CANCELADO")
					|| processo.getSituacao()
							.get(processo.getSituacao().size() - 1)
							.getSituacao().equals("SUSPENSO")) {

				if (processo.getDocArrecadacao().isIndPago() == true) {
					Situacao situacao2 = new Situacao();

					situacoes.get(processo.getSituacao().size() - 1)
							.setDataFim(s.format(new Date()));
					situacao2.setSituacao("ABERTO");
					situacao2.setDataInicio(s.format(new Date()));
					situacao2.setDataFim("__/__/____");
					situacoes.add(situacao2);
					processo.setSituacao(situacoes);
					processos.remove(cod);
					processos.put(cod, processo);
				} else {
					System.out
							.println("Processo com Pendencia, nao pode haver alteracao!");
					System.out.println("");
				}
			} else {
				System.out
						.println("Processo nao estar cancelado, nem suspenso!");
				System.out.println("");
			}
		} catch (ProcessoNaoEncontradoException e) {
			System.out.println("Processo Nao Encontrado!");
			System.out.println("");
		}
	}

	// ///////////////////////////////

	// Método que Encerrar o Processo
	public static void EncerrarProcesso() {

		System.out.println("-------ENCERRAR PROCESSO--------");

		System.out.println("Qual o codigo do processo? (ex: 1/2011)");
		String cod = letras.nextLine();

		Situacao situacao = new Situacao();
		try {
			Processo processo = ProcurarProcesso(cod);

			ArrayList<Situacao> situacoes = new ArrayList<Situacao>();
			if (processo.getSituacao() != null) {
				for (int i = 0; i < processo.getSituacao().size(); i++) {

					situacao.setDataFim(processo.getSituacao().get(i)
							.getDataFim());
					situacao.setDataInicio(processo.getSituacao().get(i)
							.getDataInicio());
					situacao.setSituacao(processo.getSituacao().get(i)
							.getSituacao());
					situacoes.add(situacao);
				}
			}

			if (processo.getSituacao().get(processo.getSituacao().size() - 1)
					.getSituacao().equals("ABERTO")) {

				if (processo.getDocArrecadacao().isIndPago() == true) {
					System.out
							.println("Qual o motivo? \n 1- DEFERIMENTO 2- POR INDEFERIMENTO.");
					int op = numeros.nextInt();

					if (op == 1) {
						Situacao situacao4 = new Situacao();
						situacoes.get(processo.getSituacao().size() - 1)
								.setDataFim(s.format(new Date()));
						situacao4.setSituacao("ENCERRADO");
						situacao4.setDataInicio(s.format(new Date()));
						situacao4.setDataFim("__/__/____");
						situacao4
								.setMotivo(Motivo_de_Encerramento.POR_DEFERIMENTO);
						situacoes.add(situacao4);
						processo.setSituacao(situacoes);
					} else {
						Situacao situacao5 = new Situacao();
						situacoes.get(processo.getSituacao().size() - 1)
								.setDataFim(s.format(new Date()));
						situacao5.setSituacao("ENCERRADO");
						situacao5.setDataInicio(s.format(new Date()));
						situacao5.setDataFim("__/__/____");
						situacao5
								.setMotivo(Motivo_de_Encerramento.POR_INDEFERIMENTO);
						situacoes.add(situacao5);
						processo.setSituacao(situacoes);
						processos.remove(cod);
						processos.put(cod, processo);
					}
				} else {
					System.out
							.println("Processo com Pendencia, nao pode haver alteracao!");
					System.out.println("");
				}
			} else {
				System.out.println("Processo nao estar aberto!");
				System.out.println("");
			}
		} catch (ProcessoNaoEncontradoException e) {
			System.out.println("Processo Nao Encontrado!");
			System.out.println("");
		}
	}

	// //////////////////////////////

	// Método que Retirar a Pendencia
	public static void RetirarPendencia() {

		System.out.println("-------RETIRAR PENDENCIA--------");

		System.out.println("Qual o codigo do processo? (ex: 1/2011)");
		String cod = letras.nextLine();

		try {
			Processo processo = ProcurarProcesso(cod);
			if (processo.getDocArrecadacao().isIndPago() == false) {
				processo.getDocArrecadacao().setIndPago(true);

				System.out
						.println("Informe a Data de Regularizacao: (ex: dd/mm/aaaa)");
				String dataPendencia = letras.nextLine();

				try {
					processo.getPendencias().setDataRegularizacao(
							s.parse(dataPendencia));
					processos.remove(cod);
					processos.put(cod, processo);
				} catch (ParseException e) {
					System.out.println("Erro.");
				}
			} else {
				System.out.println("Processo nao contem pendencias!");
				System.out.println("");
			}
		} catch (ProcessoNaoEncontradoException e) {
			System.out.println("Processo Nao Encontrado!");
			System.out.println("");
		}
	}

	// //////////////////////////////

	// Método que Imprimir o Processo
	public static void ImprimirProcesso() {

		System.out.println("Qual o codigo do processo? (ex: 1/2011)");
		String cod = letras.nextLine();

		try {
			Processo processo = ProcurarProcesso(cod);

			if (processo instanceof ProcessoIPTU) {
				System.out.println("TIPO: PROCESSO IPTU");
			}

			if (processo instanceof ProcessoISS) {
				System.out.println("TIPO: PROCESSO ISS");
			}

			if (processo instanceof ProcessoAlvaraFuncionamento) {
				System.out.println("TIPO: PROCESSO ALVARA FUNCIONAMENTO");
			}

			if (processo instanceof ProcessoPropagandaPublicidade) {
				System.out.println("TIPO: PROCESSO PROPAGANDA E PUBLICIDADE");
			}

			System.out.println("Cod: " + processo.getNumeroAno());
			System.out.println("Situação: "+processo.getSituacao().get((processo.getSituacao().size()-1)).getSituacao());
			System.out.println("Pessoa: " + processo.getPessoa().getNome());
			System.out.println("Descricao: " + processo.getDescricao());
			System.out.println("Data Abertudra: "
					+ s.format(processo.getDataAbertura()));
			System.out.println("Assunto: "
					+ processo.getAssunto().getDescricao());

			if (processo.getDocArrecadacao().isIndPago()) {
				System.out.println("Pendencia: Nao");

			} else {
				System.out.println("Pendencia: Sim");
				System.out.println("Descricao de Pendencia: "
						+ processo.getPendencias().getDescricao());
			}

			if (processo.getDocumentosObrigatorios() != null) {
				for (int i = 0; i < processo.getDocumentosObrigatorios().size(); i++) {
					System.out.println("Documento Obrigatorio: "
							+ processo.getDocumentosObrigatorios().get(i)
									.getSigla()
							+ "-"
							+ processo.getDocumentosObrigatorios().get(i)
									.getNome());
				}
			}

			if (processo.getDocumentosEntrOpc() != null) {
				for (int i = 0; i < processo.getDocumentosEntrOpc().size(); i++) {
					System.out.println("Documento Opcionais: "
							+ processo.getDocumentosEntrOpc().get(i).getSigla()
							+ "-"
							+ processo.getDocumentosEntrOpc().get(i).getNome());
				}
			}

			if (processo.getAtos() != null) {
				for (int i = 0; i < processo.getAtos().size(); i++) {
					System.out.println("Ato: "
							+ processo.getAtos().get(i).getDescricao());
				}
			}

			if (processo.getSituacao() != null) {
				for (int i = 0; i < processo.getSituacao().size(); i++) {
					System.out.println("Processo " + processo.getNumeroAno()
							+ " " + processo.getSituacao().get(i).getSituacao()
							+ " de "
							+ processo.getSituacao().get(i).getDataInicio()
							+ " a "
							+ processo.getSituacao().get(i).getDataFim());
				}
			}

			if (processo.getTramitacao() != null) {
				for (int i = 0; i < processo.getTramitacao().size(); i++) {
					System.out.println("Tramitacao: ");
					System.out
							.println("Local de Destino: "
									+ processo.getTramitacao().get(i)
											.getLocalDestino());
					System.out.println("Data de Envio: "
							+ s.format(processo.getTramitacao().get(i)
									.getDataEnvio()));
					System.out
							.println("Usuario de Envio: "
									+ processo.getTramitacao().get(i)
											.getUsuarioEnvio());
					System.out.println("Data de Recebimento: "
							+ s.format(processo.getTramitacao().get(i)
									.getDataReceb()));
					System.out
							.println("Usuario de Recebimento: "
									+ processo.getTramitacao().get(i)
											.getUsuarioReceb());
				}
			}
			System.out.println("");
			System.out.println("Usuario Cadastrador: "
					+ processo.getUsuarioCadastro());
			System.out.println("--------");
			System.out.println("");

		} catch (ProcessoNaoEncontradoException e) {
			System.out.println("Processo nao encontrado!");
			System.out.println("");
		}
	}
	// //////////////////////////////
}