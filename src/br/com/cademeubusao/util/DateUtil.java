package br.com.cademeubusao.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateUtil {
	/**
	 * Esse método é utilizado para alterar uma data zerando sua hora, minutos,
	 * segundos e milisegundos. É útil quando se vai comparar datas sem levar em
	 * consideração as horas, minutos, segundos e milisegundos
	 *
	 * @param calendario
	 *            - Intancia de <code>Calendar</code>.
	 */
	public static void zeraHoras(final Calendar calendario) {

		calendario.set(Calendar.HOUR, 0);
		calendario.set(Calendar.HOUR_OF_DAY, 0);
		calendario.set(Calendar.MINUTE, 0);
		calendario.set(Calendar.SECOND, 0);
		calendario.set(Calendar.MILLISECOND, 0);

	}
	
	/**
	 * Esse método é utilizado para alterar uma data zerando sua hora, minutos,
	 * segundos e milisegundos. É útil quando se vai comparar datas sem levar em
	 * consideração as horas, minutos, segundos e milisegundos
	 *
	 * @param data
	 *            - Intancia de <code>Date</code>.
	 */
	public static Date zeraHoras(final Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		zeraHoras(calendar);
		return calendar.getTime();
	}
	
	public static Date converterStringEmData(String data) {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");

		Date dataAtual = null;
		try {
			dataAtual = sdf.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return dataAtual;
	}
}
