import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println("Digite o horario de entrada (HH:mm): ");
        LocalTime entrada = LocalTime.parse(scanner.nextLine(), formatter);

        System.out.println("Digite a carga horaria diária em horas: ");
        int cargaHoraria = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite o horario de sua saída (HH:mm): ");
        LocalTime saida = LocalTime.parse(scanner.nextLine(), formatter);

        scanner.close();

        LocalTime saidaPrevista = entrada.plusHours(cargaHoraria);

        Duration duration = Duration.between(saida, saidaPrevista);
        long horasExtras = duration.toHours();
        long minutosExtras = duration.toMinutesPart();


        System.out.println("Horario de entrada: " + entrada);
        System.out.println("Horario de saída prevista: " + saidaPrevista.format(formatter));
        System.out.println("Horario de saída real: " + saida.format(formatter));



        if (horasExtras == 0 && minutosExtras == 0) {
            System.out.println("Saldo de horas: 0h 0min");
        } else {
            String sinal;
            if (horasExtras > 0 || minutosExtras > 0) {
                sinal = "+";
            } else {
                sinal = "-";
            }
            System.out.println("Saldo de horas: " + sinal + Math.abs(horasExtras));
        }


    }
}