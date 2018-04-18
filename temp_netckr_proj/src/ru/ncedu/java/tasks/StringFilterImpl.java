package ru.ncedu.java.tasks;

import java.util.*;

/**
 * Created by ChUd0 on 10.04.2018.
 */

public class StringFilterImpl implements StringFilter {

    private Collection<String> collection;


    public void print_all()
    {
        for(String temp : collection)
            System.out.println(temp);
    }

    public StringFilterImpl() {
        collection = new HashSet<>();
    }

    /**
     * Добавляет строку s в набор, приводя ее к нижнему регистру.
     * Если строка s уже есть в наборе, ничего не делает.
     *
     * @param s может быть null
     */
    @Override
    public void add(String s) {
        if(s == null)
        {
            collection.add(null);
            return;
        }

        boolean t = collection.add(s.toLowerCase());
    }

    /**
     * Удаляет строку s из набора (предварительно приведя ее к нижнему регистру).
     *
     * @param s может быть null
     * @return true если строка была удалена, false если строка отсутствовала в наборе.
     */
    @Override
    public boolean remove(String s) {
        boolean t = (s == null);
        if(!collection.contains( t ? null : s.toLowerCase()))
            return false;
        else {
            collection.remove(t ? null : s.toLowerCase());
            return true;
        }
    }

    /**
     * Очищает набор - удаляет из него все строки
     */
    @Override
    public void removeAll() {
        collection.removeAll(collection);


        /*
        Iterator<String> iter = collection.iterator();
        while(iter.hasNext())
        {
            iter.next();
            iter.remove();
        }*/

    }

    /**
     * Возвращает набор (коллекцию), в котором хранятся строки.
     * В наборе не может быть двух одинаковых строк, однако может быть null.
     */
    @Override
    public Collection<String> getCollection() {
        return collection;
    }

    /**
     * Ищет и возвращает все строки, содержащие указанную последовательность символов.<br/>
     * Если <code>chars</code> - пустая строка или <code>null</code>,
     * то результат содержит все строки данного набора.<br/>
     *
     * @param chars символы, входящие в искомые строки
     *              (все символы, являющиеся буквами, - в нижнем регистре)
     * @return строки, содержащие указанную последовательность символов
     */
    @Override
    public Iterator<String> getStringsContaining(String chars) {
        return null;
    }

    /**
     * Ищет и возвращает строки, начинающиеся с указанной последовательности символов,
     * (без учета регистра). <br/>
     * Если <code>begin</code> - пустая строка или <code>null</code>,
     * то результат содержит все строки данного набора.<br/>
     *
     * @param begin первые символы искомых строк
     *              (для сравнения со строками набора символы нужно привести к нижнему регистру)
     * @return строки, начинающиеся с указанной последовательности символов
     */
    @Override
    public Iterator<String> getStringsStartingWith(String begin) {

        Collection<String> new_collection = new LinkedList<>();
        if(begin == null || begin.isEmpty()) {
            for (String temp : collection) {
                new_collection.add(temp);
            }
        }
        else
        {
            for (String temp : collection) {
                if(temp == null)
                    continue;
                if(begin.length() > temp.length())
                {
                    continue;
                }
                else
                {
                    boolean should_add = true;
                    for(int i = 0 ; i < begin.length(); i++)
                    {
                        if(temp.charAt(i) == begin.charAt(i))
                            continue;
                        else {
                            should_add = false;
                            break;
                        }
                    }
                    if(should_add)
                        new_collection.add(temp);
                }
            }
        }
        return new_collection.iterator();
    }

    /**
     * Ищет и возвращает все строки, представляющие собой число в заданном формате.<br/>
     * Формат может содержать символ # (место для одной цифры от 0 до 9) и любые символы.
     * Примеры форматов: "(###)###-####" (телефон), "# ###" (целое число от 1000 до 9999),
     * "-#.##" (отрицательное число, большее -10, с ровно двумя знаками после десятичной точки).<br/>
     * Упрощающее ограничение: в строке, удовлетворяющей формату, должно быть ровно столько символов,
     * сколько в формате (в отличие от стандартного понимания числового формата,
     * где некоторые цифры на месте # не являются обязательными).<br/>
     * Примечание: в данной постановке задачи НЕ предполагается использование регулярных выражений
     * или какого-либо высокоуровневого API (эти темы изучаются позже).<br/>
     * Если <code>format</code> - пустая строка или <code>null</code>,
     * то результат содержит все строки данного набора.<br/>
     *
     * @param format формат числа
     * @return строки, удовлетворяющие заданному числовому формату
     */
    @Override
    public Iterator<String> getStringsByNumberFormat(String format) {
        return null;
    }

    /**
     * Ищет и возвращает строки, удовлетворяющие заданному шаблону поиска, содержащему символы *
     * в качестве wildcards (на месте * в строке может быть ноль или больше любых символов).<br/>
     * <a href="http://en.wikipedia.org/wiki/Wildcard_character#File_and_directory_patterns">Про * wildcard</a>.<br/>
     * Примеры шаблонов, которым удовлетворяет строка "distribute": "distr*", "*str*", "di*bute*".<br/>
     * Упрощение: достаточно поддерживать всего два символа * в шаблоне.<br/>
     * Примечание: в данной постановке задачи НЕ предполагается использование регулярных выражений
     * и какого-либо высокоуровневого API (эти темы изучаются позже), цель - применить методы String.<br/>
     * Если <code>pattern</code> - пустая строка или <code>null</code>,
     * то результат содержит все строки данного набора.<br/>
     *
     * @param pattern шаблон поиска (все буквы в нем - в нижнем регистре)
     * @return строки, удовлетворяющие заданному шаблону поиска
     */
    @Override
    public Iterator<String> getStringsByPattern(String pattern) {
        return null;
    }


    public static void main(String[] args) {
        StringFilterImpl sfi = new StringFilterImpl();
        sfi.add("threatened");
        sfi.add("that");
        sfi.add("they");
        sfi.add("than");
        sfi.add("there");
        Iterator<String> i =  sfi.getStringsStartingWith("Th");
        while(i . hasNext())
        {
            System.out.println(i.next());

        }
        //sfi.print_all();
        //sfi.removeAll();
        //sfi.print_all();
    }
}
