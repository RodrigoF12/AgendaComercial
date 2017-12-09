
package agendacomercial;

import java.sql.SQLException;
import java.util.Scanner;


public class crud extends ConexaoBD {
    public static void Cadastrar() throws SQLException 
    {
        
        Scanner in = new Scanner(System.in);
        DadosP dados = new DadosP();
        DadosPr dpr = new DadosPr();
        Telefone tel = new Telefone();
        Email mail = new Email();
        Endereco end = new Endereco();
        
        //INSERINDO NOVOS DADOS NO BANCO
        
        //DADOS PESSOAIS:
        
        System.out.println("ID:");
        dados.id_dados = Integer.parseInt(in.nextLine()); 
        System.out.println("Nome:");
        dados.nome = in.nextLine();
        System.out.println("Sobrenome:");
        dados.sobrenome = in.nextLine();
        System.out.println("Nome Social (opcional):");
        dados.n_social = in.nextLine();
        System.out.println("Data de nascimento (opcional):");
        dados.d_nasc = in.nextLine();
        System.out.println("Idioma (opcional):");
        dados.idioma = in.nextLine();
        
        // INICIA BANCO DE DADOS PARA INSERÇÃO DOS DADOS
        
        OpenDatabase();
        String SQL = "INSERT INTO DadosP VALUES(?,?,?,?,?,?)";
        ps = conexao.prepareStatement(SQL);
        ps.setInt(1, dados.id_dados);
        ps.setString(2, dados.nome);
        ps.setString(3, dados.sobrenome);
        ps.setString(4, dados.n_social);
        ps.setString(5, dados.d_nasc);
        ps.setString(6, dados.idioma);
        ps.execute();
        
        // FIM DA INSERÇÃO
        
        // INICIA INSERÇÃO DOS DADOS PROFISSIONAIS
        
        dpr.id_profi = dados.id_dados;
        System.out.println("Empresa:");
        dpr.empresa = in.nextLine();
        System.out.println("Cargo:");
        dpr.cargo = in.nextLine();
        dpr.fk = dados.id_dados;
        
        OpenDatabase();
        SQL = "INSERT INTO DadosPr VALUES(?,?,?,?)";
        ps = conexao.prepareStatement(SQL);
        ps.setInt(1, dpr.id_profi);
        ps.setString(2, dpr.empresa);
        ps.setString(3, dpr.cargo);
        ps.setInt(4, dpr.fk);
        ps.execute();
        
        //FIM INSERÇÃO
        
        // INICIA INSERÇÃO DO TELEFONE
        
        tel.id_phone = dados.id_dados;
        System.out.println("DDI:");
        tel.ddi = Integer.parseInt(in.nextLine());
        System.out.println("DDD:");
        tel.ddd = Integer.parseInt(in.nextLine());
        System.out.println("Código da Operadora:");
        tel.c_operadora = Integer.parseInt(in.nextLine());
        System.out.println("Número:");
        tel.numero = Integer.parseInt(in.nextLine());
        System.out.println("Tipo (celular, fixo...):");
        tel.tipo = in.nextLine();
        tel.fk = dados.id_dados;
        
        OpenDatabase();
        SQL = "INSERT INTO Telefone VALUES(?,?,?,?,?,?,?)";
        ps = conexao.prepareStatement(SQL);
        ps.setInt(1, tel.id_phone);
        ps.setInt(2, tel.ddi);
        ps.setInt(3, tel.ddd);
        ps.setInt(4, tel.c_operadora);
        ps.setInt(5, tel.numero);
        ps.setString(6, tel.tipo);
        ps.setInt(7, tel.fk);
        ps.execute();
        
        // FIM INSERÇÃO
        
        // INICIA INSERÇÃO DO E-MAIL
        
        mail.id_mail = dados.id_dados;
        System.out.println("E-mail:");
        mail.email = in.nextLine();
        System.out.println("Tipo de e-mail:");
        mail.tipo = in.nextLine();
        mail.fk = dados.id_dados;
        
        OpenDatabase();
        SQL = "INSERT INTO Email VALUES(?,?,?,?)";
        ps = conexao.prepareStatement(SQL);
        ps.setInt(1, mail.id_mail);
        ps.setString(2, mail.email);
        ps.setString(3, mail.tipo);
        ps.setInt(4, mail.fk);
        ps.execute();
        
        // FIM INSERÇÃO
        
        // INICIA INSERÇÃO DO ENDEREÇO
        
        System.out.println("\n Endereço:");
        
        end.id_end = dados.id_dados;
        System.out.println("Tipo (rua, avenida, praça...):");
        end.tipo = in.nextLine();
        System.out.println("Logradouro:");
        end.logradouro = in.nextLine();
        System.out.println("Número:");
        end.num = in.nextLine();
        System.out.println("Complemento:");
        end.compl = in.nextLine();
        System.out.println("Bairro:");
        end.bairro = in.nextLine();
        System.out.println("Cidade:");
        end.cidade = in.nextLine();
        System.out.println("UF:");
        end.uf = in.nextLine();
        System.out.println("País:");
        end.pais = in.nextLine();
        System.out.println("CEP:");
        end.cep = Integer.parseInt(in.nextLine());
        System.out.println("Tipo de endereço (residencial, comercial...):");
        end.categoria = in.nextLine();
        end.fk = dados.id_dados;
        
        OpenDatabase();
        SQL = "INSERT INTO Endereco VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        ps = conexao.prepareStatement(SQL);
        ps.setInt(1, end.id_end);
        ps.setString(2, end.tipo);
        ps.setString(3, end.logradouro);
        ps.setString(4, end.num);
        ps.setString(5, end.compl);
        ps.setString(6, end.bairro);
        ps.setString(7, end.cidade);
        ps.setString(8, end.uf);
        ps.setString(9, end.pais);
        ps.setInt(10, end.cep);
        ps.setString(11, end.categoria);
        ps.setInt(12, end.fk);
        ps.execute();
        ps.close();
        
        conexao.close();
        
        //FIM DA INSERÇÃO
        
        System.out.println("Dados Cadastrados com sucesso!");
    }
    
    // CADASTRAR NOVOS DADOS À CONTATOS EXISTENTES
    
    public static void Cadastrar2() throws SQLException
    {
        int op;
        Scanner in = new Scanner(System.in);
        DadosP dados = new DadosP();
        DadosPr dpr = new DadosPr();
        Telefone tel = new Telefone();
        Email mail = new Email();
        Endereco end = new Endereco();
        
        do{
            System.out.println("1. Cadastrar Empresa/cargo.");
            System.out.println("2. Cadastrar telefone.");
            System.out.println("3. Cadastrar e-mail.");
            System.out.println("4. Cadastrar endereço.");
            System.out.println("Ou digite 0 para encerrar.");
            op = Integer.parseInt(in.nextLine());
        
            switch(op)
            {
            case 1: 
                System.out.println("ID:");
                dpr.id_profi = Integer.parseInt(in.nextLine());
                System.out.println("Empresa:");
                dpr.empresa = in.nextLine();
                System.out.println("Cargo:");
                dpr.cargo = in.nextLine();
                System.out.println("Digite o ID do contato que deseja cadastrar as informações:");
                dpr.fk = Integer.parseInt(in.nextLine());
        
                OpenDatabase();
                String SQL = "INSERT INTO DadosPr VALUES(?,?,?,?)";
                ps = conexao.prepareStatement(SQL);
                ps.setInt(1, dpr.id_profi);
                ps.setString(2, dpr.empresa);
                ps.setString(3, dpr.cargo);
                ps.setInt(4, dpr.fk);
                ps.execute();  
                System.out.println("Dados Cadastrados com sucesso!");
                break;
               
            case 2:
                System.out.println("ID:");
                tel.id_phone = Integer.parseInt(in.nextLine());
                System.out.println("DDI:");
                tel.ddi = Integer.parseInt(in.nextLine());
                System.out.println("DDD:");
                tel.ddd = Integer.parseInt(in.nextLine());
                System.out.println("Código da Operadora:");
                tel.c_operadora = Integer.parseInt(in.nextLine());
                System.out.println("Número:");
                tel.numero = Integer.parseInt(in.nextLine());
                System.out.println("Tipo (celular, fixo...):");
                tel.tipo = in.nextLine();
                System.out.println("Digite o ID do contato que deseja cadastrar as informações:");
                tel.fk = Integer.parseInt(in.nextLine());
                
        
                OpenDatabase();
                SQL = "INSERT INTO Telefone VALUES(?,?,?,?,?,?,?)";
                ps = conexao.prepareStatement(SQL);
                ps.setInt(1, tel.id_phone);
                ps.setInt(2, tel.ddi);
                ps.setInt(3, tel.ddd);
                ps.setInt(4, tel.c_operadora);
                ps.setInt(5, tel.numero);
                ps.setString(6, tel.tipo);
                ps.setInt(7, tel.fk);
                ps.execute();
                System.out.println("Dados Cadastrados com sucesso!");
                break;
                
            case 3:
                System.out.println("ID:");
                mail.id_mail = Integer.parseInt(in.nextLine());
                System.out.println("E-mail:");
                mail.email = in.nextLine();
                System.out.println("Tipo de e-mail:");
                mail.tipo = in.nextLine();
                System.out.println("Digite o ID do contato que deseja cadastrar as informações as informações:");
                mail.fk = Integer.parseInt(in.nextLine());
        
                OpenDatabase();
                SQL = "INSERT INTO Email VALUES(?,?,?,?)";
                ps = conexao.prepareStatement(SQL);
                ps.setInt(1, mail.id_mail);
                ps.setString(2, mail.email);
                ps.setString(3, mail.tipo);
                ps.setInt(4, mail.fk);
                ps.execute();
                System.out.println("Dados Cadastrados com sucesso!");
                break;
                
            case 4: 
                System.out.println("ID:");
                end.id_end = Integer.parseInt(in.nextLine());  
                end.id_end = dados.id_dados;
                System.out.println("Tipo (rua, avenida, praça...):");
                end.tipo = in.nextLine();
                System.out.println("Logradouro:");
                end.logradouro = in.nextLine();
                System.out.println("Número:");
                end.num = in.nextLine();
                System.out.println("Complemento:");
                end.compl = in.nextLine();
                System.out.println("Bairro:");
                end.bairro = in.nextLine();
                System.out.println("Cidade:");
                end.cidade = in.nextLine();
                System.out.println("UF:");
                end.uf = in.nextLine();
                System.out.println("País:");
                end.pais = in.nextLine();
                System.out.println("CEP:");
                end.cep = Integer.parseInt(in.nextLine());
                System.out.println("Tipo de endereço (residencial, comercial...):");
                end.categoria = in.nextLine();
                System.out.println("Digite o ID do contato que deseja cadastrar as informações:");
                end.fk = Integer.parseInt(in.nextLine());
        
                OpenDatabase();
                SQL = "INSERT INTO Endereco VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
                ps = conexao.prepareStatement(SQL);
                ps.setInt(1, end.id_end);
                ps.setString(2, end.tipo);
                ps.setString(3, end.logradouro);
                ps.setString(4, end.num);
                ps.setString(5, end.compl);
                ps.setString(6, end.bairro);
                ps.setString(7, end.cidade);
                ps.setString(8, end.uf);
                ps.setString(9, end.pais);
                ps.setInt(10, end.cep);
                ps.setString(11, end.categoria);
                ps.setInt(12, end.fk);
                ps.execute();
                System.out.println("Dados Cadastrados com sucesso!");
                break;
            }    
        } while(op!=0);
        
    }
    //LISTAGEM DE TODOS OS DADOS DO BANCO
    
    public static void Listagem() throws SQLException
    {
       OpenDatabase();
       String SQL = "SELECT* from DadosP INNER JOIN DadosPr ON DadosP.id_dados = DadosPr.id_dados INNER JOIN Telefone ON DadosP.id_dados = Telefone.id_dados INNER JOIN Email ON DadosP.id_dados = Email.id_dados INNER JOIN Endereco ON DadosP.id_dados = Endereco.id_dados";
       ps = conexao.prepareStatement(SQL);
       rs = ps.executeQuery();
       
       while(rs.next()){
           System.out.println("Listando dados...");
           System.out.println("Id: " + rs.getInt("id_dados"));
           System.out.println("Nome: " + rs.getString("nome"));
           System.out.println("Sobrenome: " + rs.getString("sobrenome"));
           System.out.println("Nome Social: " + rs.getString("nome_social"));
           System.out.println("Data de Nascimento " + rs.getString("D_nasc"));
           System.out.println("Idioma: " + rs.getString("idioma"));
           System.out.println("Empresa: " + rs.getString("empresa"));
           System.out.println("Cargo: " + rs.getString("cargo"));
           System.out.println("DDI:" + rs.getInt("ddi"));
           System.out.println("DDD: " + rs.getInt("ddd"));
           System.out.println("Código da Operadora: " + rs.getInt("c_operadora"));
           System.out.println("Telefone: " + rs.getInt("numero"));
           System.out.println("Tipo:" + rs.getString("Telefone.tipo"));
           System.out.println("E-mail: " + rs.getString("email"));
           System.out.println("Tipo: " + rs.getString("Email.tipo"));
           System.out.println("Endereço: " + rs.getString("Endereco.tipo") + " " + rs.getString("logradouro")
           + ", " + rs.getString("num")+ " " + rs.getString("compl") + ", " + rs.getString("bairro")+ " | " + rs.getString("cidade")
           + "-" + rs.getString("uf") + "-" + rs.getString("pais")+ " CEP:" + rs.getInt("cep") + " Tipo de endereço: " + rs.getString("categoria"));
           
           
       } 
    }
    
    //PESQUISA INDIVIDUAL POR NOME DE CONTATOS
    
    public static void Consultar() throws SQLException 
    {
        String consulta;
        Scanner in = new Scanner(System.in);
        
        System.out.println("Digite o nome do contato:");
        consulta = in.nextLine();
        
        OpenDatabase();
        String SQL = "SELECT* from DadosP INNER JOIN DadosPr ON DadosP.id_dados = DadosPr.id_dados INNER JOIN Telefone ON DadosP.id_dados = Telefone.id_dados INNER JOIN Email ON DadosP.id_dados = Email.id_dados INNER JOIN Endereco ON DadosP.id_dados = Endereco.id_dados WHERE DadosP.nome = ?";
        ps = conexao.prepareStatement(SQL);
        ps.setString(1,consulta);
        rs = ps.executeQuery();
        ps.execute();
        ps.close();
        
        while(rs.next()){
           System.out.println("Listando dados... \n");
           System.out.println("Id: " + rs.getInt("id_dados"));
           System.out.println("Nome: " + rs.getString("nome"));
           System.out.println("Sobrenome: " + rs.getString("sobrenome"));
           System.out.println("Nome Social: " + rs.getString("nome_social"));
           System.out.println("Data de Nascimento " + rs.getString("D_nasc"));
           System.out.println("Idioma: " + rs.getString("idioma"));
           System.out.println("Empresa: " + rs.getString("empresa"));
           System.out.println("Cargo: " + rs.getString("cargo"));
           System.out.println("DDI:" + rs.getInt("ddi"));
           System.out.println("DDD: " + rs.getInt("ddd"));
           System.out.println("Código da Operadora: " + rs.getInt("c_operadora"));
           System.out.println("Telefone: " + rs.getInt("numero"));
           System.out.println("Tipo:" + rs.getString("Telefone.tipo"));
           System.out.println("E-mail: " + rs.getString("email"));
           System.out.println("Tipo: " + rs.getString("Email.tipo"));
           System.out.println("Endereço: " + rs.getString("Endereco.tipo") + " " + rs.getString("logradouro")
           + ", " + rs.getString("num")+ " " + rs.getString("compl") + ", " + rs.getString("bairro")+ " | " + rs.getString("cidade")
           + "-" + rs.getString("uf") + "-" + rs.getString("pais")+ " CEP:" + rs.getInt("cep") + " Tipo de endereço: " + rs.getString("categoria"));
        
    }
    }
    
    //ATUALIZAR DADOS
    
    public static void Atualizar() throws SQLException
    {
        Scanner in = new Scanner(System.in); 
        DadosP d = new DadosP();
        int op;
        DadosPr dpr = new DadosPr();
        Telefone tel = new Telefone();
        Email mail = new Email();
        Endereco end = new Endereco();
        
        System.out.println("Digite o nome do contato que deseja atualizar informações:");
        d.nome = in.nextLine();
        
        System.out.println("Esses são os contatos registrados com o nome informado:");
                
        OpenDatabase();
        String SQL = "SELECT id_dados, nome FROM DadosP WHERE nome = ?";
        ps = conexao.prepareStatement(SQL);
        ps.setString(1,d.nome);
        rs = ps.executeQuery();
        ps.execute();
        ps.close();
        
        while(rs.next())
        {
           System.out.println("Id: " + rs.getInt("id_dados"));
           System.out.println("Nome: " + rs.getString("nome"));
        }
        
            System.out.println("Qual o ID do contato?:");
            d.id_dados = Integer.parseInt(in.nextLine());
        
            do{
                System.out.println("O que deseja atualizar?");
                System.out.println("1. Dados profissionais.");
                System.out.println("2. Telefone.");
                System.out.println("3. E-mail.");
                System.out.println("4. Endereço.");
                System.out.println("Ou digite 0 para sair.");
                op = Integer.parseInt(in.nextLine());
        
                switch(op){
            
                    case 1:
        
                        System.out.println("Empresa:");
                        dpr.empresa = in.nextLine();
                        System.out.println("Cargo:");
                        dpr.cargo = in.nextLine();
         
                        OpenDatabase();
                        SQL = "UPDATE DadosPr SET empresa =?, cargo=? WHERE id_dados =?";
                        ps = conexao.prepareStatement(SQL);
                        ps.setInt(3, d.id_dados);
                        ps.setString(1, dpr.empresa);
                        ps.setString(2, dpr.cargo);
                        ps.executeUpdate();
                        
                        System.out.println("Dados atualizados!");
                        break;
                
                    case 2:
                        System.out.println("DDI:");
                        tel.ddi = Integer.parseInt(in.nextLine());
                        System.out.println("DDD:");
                        tel.ddd = Integer.parseInt(in.nextLine());
                        System.out.println("Código da Operadora:");
                        tel.c_operadora = Integer.parseInt(in.nextLine());
                        System.out.println("Número:");
                        tel.numero = Integer.parseInt(in.nextLine());
                        System.out.println("Tipo:");
                        tel.tipo = in.nextLine();
        
                        OpenDatabase();
                        SQL = "UPDATE Telefone SET ddi =?, ddd=?, c_operadora =?, numero = ?, tipo =? WHERE id_dados =?";
                        ps = conexao.prepareStatement(SQL);
                        ps.setInt(6, d.id_dados);
                        ps.setInt(1, tel.ddi);
                        ps.setInt(2, tel.ddd);
                        ps.setInt(3, tel.c_operadora);
                        ps.setInt(4, tel.numero);
                        ps.setString(5, tel.tipo);
                        ps.executeUpdate();
                        System.out.println("Dados atualizados!");
                        break;
                
                    case 3:
                        System.out.println("E-mail:");
                        mail.email = in.nextLine();
                        System.out.println("Tipo:");
                        mail.tipo = in.nextLine();
                        OpenDatabase();
                        SQL = "UPDATE Email SET email =?, tipo=? WHERE id_dados =?";
                        ps = conexao.prepareStatement(SQL);
                        ps.setInt(3, d.id_dados);
                        ps.setString(1, mail.email);
                        ps.setString(2, mail.tipo);
                        ps.executeUpdate();
                        System.out.println("Dados atualizados!");
                        break;
                
                    case 4:
                        System.out.println("Tipo:");
                        end.tipo = in.nextLine();
                        System.out.println("Logradouro:");
                        end.logradouro = in.nextLine();
                        System.out.println("Número:");
                        end.num = in.nextLine();
                        System.out.println("Complemento:");
                        end.compl = in.nextLine();
                        System.out.println("Bairro:");
                        end.bairro = in.nextLine();
                        System.out.println("Cidade:");
                        end.cidade = in.nextLine();
                        System.out.println("UF:");
                        end.uf = in.nextLine();
                        System.out.println("País:");
                        end.pais = in.nextLine();
                        System.out.println("CEP:");
                        end.cep = Integer.parseInt(in.nextLine());
                        System.out.println("Categoria:");
                        end.categoria = in.nextLine();
        
                        OpenDatabase();
                        SQL = "UPDATE Endereco SET tipo=?, logradouro=?, num=?, compl=?, bairro=?, cidade=?, uf=?, pais=?, cep=?, categoria=? WHERE id_dados =?";
                        ps = conexao.prepareStatement(SQL);
                        ps.setInt(11, d.id_dados);
                        ps.setString(1, end.tipo);
                        ps.setString(2, end.logradouro);
                        ps.setString(3, end.num);
                        ps.setString(4, end.compl);
                        ps.setString(5, end.bairro);
                        ps.setString(6, end.cidade);
                        ps.setString(7, end.uf);
                        ps.setString(8, end.pais);
                        ps.setInt(9, end.cep);
                        ps.setString(10, end.categoria);
                        ps.executeUpdate();
                        System.out.println("Dados atualizados!");
                        break;
                }
            } while(op!=0);
    }
    
    public static void Deletar() throws SQLException
    {
        Scanner in = new Scanner(System.in); 
        DadosP d = new DadosP();
        
        System.out.println("Digite o nome do contato que deseja deletar:");
        d.nome = in.nextLine();
        
        System.out.println("Esses são os contatos registrados com o nome informado:");
                
        OpenDatabase();
        String SQL = "SELECT id_dados, nome FROM DadosP WHERE nome = ?";
        ps = conexao.prepareStatement(SQL);
        ps.setString(1,d.nome);
        rs = ps.executeQuery();
        ps.execute();
        ps.close();
        
        while(rs.next()){
           System.out.println("Id: " + rs.getInt("id_dados"));
           System.out.println("Nome: " + rs.getString("nome"));
        }
        
        System.out.println("Digite o ID do contato que deseja deletar:");
        d.id_dados = Integer.parseInt(in.nextLine());
        
        OpenDatabase();
        SQL = "DELETE from DadosP WHERE id_dados =" + d.id_dados;
        ps = conexao.prepareStatement(SQL);
        ps.executeUpdate(SQL);
        System.out.println("Dados deletados.");
    }
    
          
}
