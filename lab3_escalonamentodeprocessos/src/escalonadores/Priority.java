package escalonadores;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

import modelos.Processo;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Priority implements Comparator<Processo> {

	public int compare(Processo p1, Processo p2) {
        if(p1.prioridade < p2.prioridade)
        	return 1;
        if(p1.prioridade > p2.prioridade) 
        	return -1;
        return 0;
    }

	public Comparator reversed() {
		return null;
	}

	public Comparator thenComparing(Comparator other) {
		return null;
	}

	public Comparator thenComparing(Function keyExtractor,
			Comparator keyComparator) {
		return null;
	}

	public Comparator thenComparing(Function keyExtractor) {
		return null;
	}

	public Comparator thenComparingInt(ToIntFunction keyExtractor) {
		return null;
	}

	public Comparator thenComparingLong(ToLongFunction keyExtractor) {
		return null;
	}

	public Comparator thenComparingDouble(ToDoubleFunction keyExtractor) {
		return null;
	}

	public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
		return null;
	}

	public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
		return null;
	}

	public static <T> Comparator<T> nullsFirst(Comparator<? super T> comparator) {
		return null;
	}

	public static <T> Comparator<T> nullsLast(Comparator<? super T> comparator) {
		return null;
	}

	public static <T, U> Comparator<T> comparing(
			Function<? super T, ? extends U> keyExtractor,
			Comparator<? super U> keyComparator) {
		return null;
	}

	public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
			Function<? super T, ? extends U> keyExtractor) {
		return null;
	}

	public static <T> Comparator<T> comparingInt(
			ToIntFunction<? super T> keyExtractor) {
		return null;
	}

	public static <T> Comparator<T> comparingLong(
			ToLongFunction<? super T> keyExtractor) {
		return null;
	}

	public static <T> Comparator<T> comparingDouble(
			ToDoubleFunction<? super T> keyExtractor) {
		return null;
	}

}