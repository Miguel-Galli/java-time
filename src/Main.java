import java.time.*;
import java.time.format.DateTimeFormatter;


public class Main {
    public static void main(String[] args) {
        LocalDate dataCompra = LocalDate.now();
        LocalDate dataPrimeiraParcela = LocalDate.of(2025,5,25);
        LocalDate dataSegundaParcela = dataPrimeiraParcela.plusDays(30);

        if (dataPrimeiraParcela.isEqual(LocalDate.now())) {
            System.out.println("Hoje é o dia do vencimento");
        } else {
            System.out.println("Ainda não está no dia do vencimento");
        }

        System.out.println("Data da compra: " + dataCompra);
        System.out.println("Data da primeira parcela: " + dataPrimeiraParcela);
        System.out.println("Data da segunda parcela: " + dataSegundaParcela);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("\nData da compra formatada: " + dataCompra.format(formatter));

        ZonedDateTime dataConclusaoCompra = ZonedDateTime.now();
        System.out.println("\nData conclusão da compra: " + dataConclusaoCompra);

        ZonedDateTime dataCompraNY = dataConclusaoCompra.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("Data conclusão da compra NY: " + dataCompraNY);

        LocalTime inicio = LocalTime.of(9,0);
        LocalTime fim = LocalTime.of(17,30);

        Duration duration = Duration.between(inicio, fim);
        System.out.println("\nA duração do expediente: " + duration.toHours() + " horas e " + duration.toMinutesPart() + " minutos" );

        LocalDate dataPagamento = LocalDate.parse("2025-10-30");
        Period periodo = Period.between(dataCompra, dataPagamento);
        System.out.println("\nDiferença em dias é: " + periodo.getDays());

    }
}