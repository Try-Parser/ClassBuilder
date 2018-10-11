# ClassBuilder

## Usage

````Java

Class Foo {
  private String bar;
  private Int size;

 // settters and getters
}

Foo foo = CBuilder.builder
          .start(Foo.class)
          .setKey('bar', 'code')
          .setKey('size', 1)
          .build();

````

## [Repository https://mvnrepository.com/artifact/io.github.try-parser/ClassBuilder](https://mvnrepository.com/artifact/io.github.try-parser/ClassBuilder)
