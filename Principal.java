import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Principal {

    public static void main(String[] args) {

        // 3.1 - Inserir todos os funcionários
        List<Funcionario> funcionarios = criarFuncionarios();

        // 3.2 - Remover o funcionário João
        funcionarios.removeIf(
                funcionario -> funcionario.getNome().equals("João")
        );

        System.out.println("Funcionários cadastrados: " + funcionarios.size());

        // 3.3 - Imprimir funcionários
        System.out.println("\n--- FUNCIONÁRIOS ---");
        imprimirFuncionarios(funcionarios);

        // 3.4 - Aplicar aumento de 10%
        aplicarAumento(funcionarios);

        System.out.println("\n--- APÓS AUMENTO DE 10% ---");
        imprimirFuncionarios(funcionarios);

        // 3.5 - Agrupar funcionários por função
        Map<String, List<Funcionario>> funcionariosPorFuncao =
                agruparPorFuncao(funcionarios);

        // 3.6 - Imprimir funcionários agrupados por função
        System.out.println("\n--- FUNCIONÁRIOS POR FUNÇÃO ---");
        imprimirFuncionariosPorFuncao(funcionariosPorFuncao);

        // 3.8 - Imprimir aniversariantes de outubro e dezembro
        System.out.println("\n--- ANIVERSARIANTES DE OUTUBRO E DEZEMBRO ---");
        imprimirAniversariantes(funcionarios);

        // 3.9 - Imprimir o funcionário mais velho
        System.out.println("\n--- FUNCIONÁRIO MAIS VELHO ---");
        imprimirFuncionarioMaisVelho(funcionarios);

        // 3.10 - Imprimir funcionários em ordem alfabética
        System.out.println("\n--- FUNCIONÁRIOS EM ORDEM ALFABÉTICA ---");
        imprimirEmOrdemAlfabetica(funcionarios);

        // 3.11 - Imprimir o total dos salários
        System.out.println("\n--- TOTAL DOS SALÁRIOS ---");
        imprimirTotalSalarios(funcionarios);

        // 3.12 - Imprimir quantos salários mínimos cada funcionário ganha
        System.out.println("\n--- SALÁRIOS MÍNIMOS POR FUNCIONÁRIO ---");
        imprimirSalariosMinimos(funcionarios);
    }


    // 3.1 - Criação da lista de funcionários
    private static List<Funcionario> criarFuncionarios() {

        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario(
                "Maria",
                LocalDate.of(2000, 10, 18),
                new BigDecimal("2009.44"),
                "Operador"
        ));

        funcionarios.add(new Funcionario(
                "João",
                LocalDate.of(1990, 5, 20),
                new BigDecimal("2284.38"),
                "Operador"
        ));

        funcionarios.add(new Funcionario(
                "Caio",
                LocalDate.of(1961, 5, 2),
                new BigDecimal("9836.14"),
                "Coordenador"
        ));

        funcionarios.add(new Funcionario(
                "Miguel",
                LocalDate.of(1988, 10, 14),
                new BigDecimal("19119.88"),
                "Diretor"
        ));

        funcionarios.add(new Funcionario(
                "Alice",
                LocalDate.of(1995, 1, 5),
                new BigDecimal("2234.68"),
                "Recepcionista"
        ));

        funcionarios.add(new Funcionario(
                "Heitor",
                LocalDate.of(1999, 11, 19),
                new BigDecimal("1582.72"),
                "Operador"
        ));

        funcionarios.add(new Funcionario(
                "Arthur",
                LocalDate.of(1993, 3, 31),
                new BigDecimal("4071.84"),
                "Contador"
        ));

        funcionarios.add(new Funcionario(
                "Laura",
                LocalDate.of(1994, 7, 8),
                new BigDecimal("3017.45"),
                "Gerente"
        ));

        funcionarios.add(new Funcionario(
                "Heloísa",
                LocalDate.of(2003, 5, 24),
                new BigDecimal("1606.85"),
                "Eletricista"
        ));

        funcionarios.add(new Funcionario(
                "Helena",
                LocalDate.of(1996, 9, 2),
                new BigDecimal("2799.93"),
                "Gerente"
        ));

        return funcionarios;
    }


    // 3.3 - Imprimir funcionários formatados
    private static void imprimirFuncionarios(List<Funcionario> funcionarios) {

        DateTimeFormatter formatoData =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        NumberFormat formatoSalario =
                NumberFormat.getNumberInstance(new Locale("pt", "BR"));

        formatoSalario.setMinimumFractionDigits(2);
        formatoSalario.setMaximumFractionDigits(2);

        for (Funcionario funcionario : funcionarios) {

            System.out.println("Nome: " + funcionario.getNome());

            System.out.println(
                    "Data de nascimento: "
                    + funcionario.getDataNascimento().format(formatoData)
            );

            System.out.println(
                    "Salário: R$ "
                    + formatoSalario.format(funcionario.getSalario())
            );

            System.out.println("Função: " + funcionario.getFuncao());

            System.out.println("----------------------------");
        }
    }


    // 3.4 - Aumento de 10%
    private static void aplicarAumento(List<Funcionario> funcionarios) {

        for (Funcionario funcionario : funcionarios) {

            funcionario.setSalario(
                    funcionario.getSalario().multiply(new BigDecimal("1.10"))
            );
        }
    }


    // 3.5 - Agrupar funcionários por função
    private static Map<String, List<Funcionario>> agruparPorFuncao(
            List<Funcionario> funcionarios) {

        return funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
    }


    // 3.6 - Imprimir funcionários agrupados por função
    private static void imprimirFuncionariosPorFuncao(
            Map<String, List<Funcionario>> funcionariosPorFuncao) {

        for (Map.Entry<String, List<Funcionario>> grupo
                : funcionariosPorFuncao.entrySet()) {

            System.out.println("Função: " + grupo.getKey());

            for (Funcionario funcionario : grupo.getValue()) {
                System.out.println(" - " + funcionario.getNome());
            }

            System.out.println("----------------------------");
        }
    }


    // 3.8 - Imprimir aniversariantes de outubro e dezembro
    private static void imprimirAniversariantes(
            List<Funcionario> funcionarios) {

        for (Funcionario funcionario : funcionarios) {

            int mes = funcionario.getDataNascimento().getMonthValue();

            if (mes == 10 || mes == 12) {

                System.out.println(
                        funcionario.getNome()
                        + " - "
                        + funcionario.getDataNascimento().format(
                                DateTimeFormatter.ofPattern("dd/MM/yyyy")
                        )
                );
            }
        }
    }


    // 3.9 - Encontrar e imprimir o funcionário mais velho
    private static void imprimirFuncionarioMaisVelho(
            List<Funcionario> funcionarios) {

        Funcionario maisVelho = funcionarios.get(0);

        for (Funcionario funcionario : funcionarios) {

            if (funcionario.getDataNascimento()
                    .isBefore(maisVelho.getDataNascimento())) {

                maisVelho = funcionario;
            }
        }

        int idade = Period.between(
                maisVelho.getDataNascimento(),
                LocalDate.now()
        ).getYears();

        System.out.println("Nome: " + maisVelho.getNome());
        System.out.println("Idade: " + idade + " anos");
    }


    // 3.10 - Ordenar e imprimir funcionários alfabeticamente
    private static void imprimirEmOrdemAlfabetica(
            List<Funcionario> funcionarios) {

        List<Funcionario> funcionariosOrdenados =
                new ArrayList<>(funcionarios);

        funcionariosOrdenados.sort(
                Comparator.comparing(Funcionario::getNome)
        );

        for (Funcionario funcionario : funcionariosOrdenados) {
            System.out.println(funcionario.getNome());
        }
    }


    // 3.11 - Calcular e imprimir o total dos salários
    private static void imprimirTotalSalarios(
            List<Funcionario> funcionarios) {

        BigDecimal total = BigDecimal.ZERO;

        for (Funcionario funcionario : funcionarios) {

            total = total.add(funcionario.getSalario());
        }

        NumberFormat formatoSalario =
                NumberFormat.getNumberInstance(new Locale("pt", "BR"));

        formatoSalario.setMinimumFractionDigits(2);
        formatoSalario.setMaximumFractionDigits(2);

        System.out.println(
                "Total dos salários: R$ "
                + formatoSalario.format(total)
        );
    }


    // 3.12 - Calcular quantos salários mínimos cada funcionário ganha
    private static void imprimirSalariosMinimos(
            List<Funcionario> funcionarios) {

        BigDecimal salarioMinimo = new BigDecimal("1212.00");

        for (Funcionario funcionario : funcionarios) {

            BigDecimal quantidade = funcionario.getSalario()
                    .divide(salarioMinimo, 2, RoundingMode.HALF_UP);

            System.out.println(
                    funcionario.getNome()
                    + " - "
                    + quantidade
                    + " salários mínimos"
            );
        }
    }
}