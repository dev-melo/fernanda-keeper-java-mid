package dev.melo;
import dev.melo.carro.Carro2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // List<String> list = List.of("apple", "banana", "cherry");
        List<String> list = new ArrayList<>();
        list.add("apple blue");
        list.add("apple green");
        list.add("banana");
        list.add("apple white");
        list.add("cherry");
        list.add("apple");

        list.get(0); // > apple
        System.out.println("List) " + list);
        System.out.println();

        Set<String> setStr = new HashSet<>(); // classe que implementa interface de Set, implementação mais comum
        // HashSet é baseada em uma tabela de disperção. uma forma de implementar uma lista e evitar colisões
        // HashTable é um conceito geral da programação, usando ele para implementar dados do tipo Set.
        setStr.add("Iori");
        setStr.add("Felipe");
        setStr.add("Sueli");
        setStr.add("Jose");
        setStr.add("Felipe"); // < duplicata ele verifica e não add
        System.out.println("Set) " + setStr);
        System.out.println("Set) " + setStr.contains("Felipe")); // < retorna um boolean
        System.out.println();

        Map<String, String> map =  new HashMap<>();
        map.put("Map) name", "Felipe");
        map.put("Map) lastname", "Melo");

        var name = map.get("Map) name"); // < recupera o valor atrelado a chave 'name'
        System.out.println("Map) name: " + name);
        System.out.println("Map) lastname: " + map.get("lastname"));
        System.out.println("Map) "+map.get("idade")); // < retorna null
        System.out.println();

        Queue<String> queue = new LinkedList<>(); // < duplamente linkadas/encadeadas 'posição atual aponta para a posição anterior e para a proxima
        // Pq isso é uma fila: todo valor dentro aponta para o proximo valor  (null), quando um novo é add o ponteiro aponta para o proximo

        queue.add("Felipe");
        queue.add("Melo");
        System.out.println("Queue: " + queue); // mostra a fila
        System.out.println("Queue: " + queue.peek()); // acessar e não remover da fila
        System.out.println("Queue: " + queue); // mostra a fila
        System.out.println("Queue: " + queue.poll());// < retorna o primeiro valor e remove ele da fila.
        System.out.println("Queue: " + queue);
        System.out.println("Queue: " + queue.remove()); // remove o primeiro da fila. Lança uma exception quando não tem ngm na fila.
        System.out.println("Queue: " + queue);
        System.out.println();

        LinkedList<String> linkedList = new LinkedList<>() ;// usar como uma lista encadeada pura. Tendo outros metodos disponiveis
        linkedList.addFirst("Add no Inicio");
        linkedList.addLast("Add no Final");
        linkedList.get(0); //< pega pela posição
        linkedList.getFirst(); //< pega inicial
        linkedList.getLast(); //< pega final

        System.out.println("- Records -");
        Carro2 sandero = new Carro2("Sandero", "Preto", 2022, "ABI-0R1"); // usados muito para DTOs
        System.out.println(sandero.ano());
        System.out.println();
        // DTOs => data transfer objects
        // POJOs => plain old java objects

        System.out.println("- STREAM API -");
        List<String> apples = list
                .stream()
                .filter(nome -> nome.startsWith("apple"))
                .map(String::toUpperCase) //< é o mesmo que 'nome -> nome.toUpperCase()' | Pq String? pq é o tipo da lista List<String>
                .toList();
        System.out.println(apples);

        String apples2 = list
                .stream()
                .filter(nome -> nome.startsWith("apple"))
                .map(String::toUpperCase) //< é o mesmo que 'nome -> nome.toUpperCase()' | Pq String? pq é o tipo da lista List<String>
                .map(nome -> nome.replace(" ", ""))
                .reduce("", (a, b) -> a + b);

        System.out.println(apples2);

        Set<String> apples3 = list
                .stream()
                .filter(nome -> nome.startsWith("apple"))
                .map(String::toUpperCase) //< é o mesmo que 'nome -> nome.toUpperCase()' | Pq String? pq é o tipo da lista List<String>
                .collect(Collectors.toSet());
        System.out.println(apples3);


    }
}