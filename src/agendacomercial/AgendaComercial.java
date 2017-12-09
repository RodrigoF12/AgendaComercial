
package agendacomercial;

import java.sql.SQLException;
import java.util.Scanner;

public class AgendaComercial {

 
    public static void main(String[] args) throws SQLException 
    {
        int op1, op2, op3;
        Scanner in = new Scanner(System.in);
        crud metodo = new crud();
        
        do
        {
            System.out.println("|| AGENDA COMERCIAL ||");
            System.out.println("\n Por favor, escolha uma das opções abaixo:");
            System.out.println("\n 1. Adicionar um novo contato.");
            System.out.println("\n 2. Mostrar todos os contatos.");
            System.out.println("\n 3. Pesquisar um contato.");
            System.out.println("\n 4. Atualizar um contato.");
            System.out.println("\n 5. Deletar um contato.");
            System.out.println("\n Ou digite 0 para encerrar e sair do menu.");
            op1 = Integer.parseInt(in.nextLine());
        
            switch(op1)
            {
            case 1:
                System.out.println("1. Cadastro novo.");
                System.out.println("2. Adicionar dados à contato existente.");
                op2 = Integer.parseInt(in.nextLine());
                
                if(op2 == 1)
                {
                    crud.Cadastrar();
                } else 
                {
                    crud.Cadastrar2();
                }
                    break;
            
            case 2: 
                crud.Listagem();
                break;
            
            case 3:
                crud.Consultar();
                break;
            
            case 4:
                crud.Atualizar();
                break;
            case 5: 
                crud.Deletar();
                break;
                
            }
        } while(op1!=0);
    }
    
}
