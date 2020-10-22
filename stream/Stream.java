        //creating a stream
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> stream1 = list.stream();

        String[] arr = {"basketball", "football", "volleyball"};
        Stream<String> stream2 = Arrays.stream(arr);

        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));
//        listStream.flatMap(i->i.stream()).forEach(System.out::println);

        Stream<Double> generate = Stream.generate(() -> Math.random());
        generate.limit(5).forEach(i-> System.out.println(i));

        Stream.iterate(5, n->n+1).limit(5).forEach(i-> System.out.println(i));
