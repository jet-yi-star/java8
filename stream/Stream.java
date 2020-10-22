        //creating a stream
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        List<Book> books = Arrays.asList(new Book(1,"math",50), new Book(2, "bio",40), new Book(3, "english",90));
        Stream<Integer> stream1 = list.stream();

        String[] arr = {"basketball", "football", "volleyball"};
        Stream<String> stream2 = Arrays.stream(arr);

        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));


        Stream<Double> generate = Stream.generate(() -> Math.random());
        generate.limit(5).forEach(i-> System.out.println(i));

        Stream.iterate(5, n->n+1).limit(5).forEach(i-> System.out.println(i));

        //map
        list.stream().map(i->i * i).forEach(i-> System.out.println(i));
        list.stream().mapToInt(i->i).forEach(i-> System.out.println(i));
//        listStream.forEach(System.out::println);
        listStream.flatMap(i->i.stream()).forEach(System.out::println);

        //filter
        list.stream().filter(i -> i%2 == 1).forEach(System.out::println);

        //slicing
        list.stream().limit(3).forEach(System.out::println); // 1 2 3
        list.stream().skip(2).forEach((System.out::println)); // 4 5

        //sorting
        list.stream().sorted((a,b)->{return b - a;}).forEach(System.out::println);
        list.stream().sorted(Integer::compareTo).forEach((System.out::println));
        books.stream().sorted(Comparator.comparing(a->a.getName())).forEach(System.out::println);
        books.stream().sorted(Comparator.comparing(Book::getName).reversed()).forEach(System.out::println);

        //geting unique
        List<Integer> repeatList = Arrays.asList(1,1,3,3,9,9,9);
        repeatList.stream().distinct().forEach(System.out::println);

        //reducer
        System.out.println(repeatList.stream().count());
        System.out.println(books.stream().anyMatch(b->b.getMoney()>50)); //anyMatch, allMatch, noneMatch
        System.out.println(books.stream().findFirst().get()); //findFirst, findAny
        System.out.println(books.stream().max(Comparator.comparing(Book::getMoney)).get());
        System.out.println(books.stream().min(Comparator.comparing(Book::getMoney)).get());

        //reducing, perform general purpose production
        System.out.println(books.stream().map(b->b.getMoney()).reduce((a,b)->{return a + b;}).get());

        //Collectors
        Map<String, Integer> m1 = books.stream().collect(Collectors.toMap(b->b.getName(), b->b.getMoney()));
        Map<String, Integer> m2 = books.stream().collect(Collectors.toMap(Book::getName, Book::getMoney));
        Map<String, Book> m3 = books.stream().collect(Collectors.toMap(Book::getName, Function.identity()));
        System.out.println(m3);
        books.stream().collect(Collectors.toList());
        books.stream().collect(Collectors.toSet());
        books.stream().collect(Collectors.summingInt(b->b.getMoney()));//summingDouble
        IntSummaryStatistics collect = books.stream().collect(Collectors.summarizingInt(Book::getMoney)); // summarizingDouble
        System.out.println(collect);
        //join using delimiter
        String collect1 = books.stream().map(b -> b.getName()).collect(Collectors.joining(","));
        System.out.println(collect1);

        //primitive type streams
        IntStream.range(1,5).forEach(System.out::println);
        IntStream.rangeClosed(1,5).forEach(System.out::println);
