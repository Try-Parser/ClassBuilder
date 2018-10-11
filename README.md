# ClassBuilder

### Usage

````java
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
