The Matching Familiar Figures Test, MFFT
=============

The Matching Familiar Figures Test, invented by [Jerome Kagan] in 1966, used to diagnose cognitive style impulsivity - reflexivity.

Example of demo training case

![alt text][demo]


### How to run locally:

```sh
$ gradlew run
```

### How to build Jar executable:

```sh
$ gradlew assemble
```

You could later run jar (JDK is required) located in `build/distributions`

### How to build native package:

```sh
$ gradlew jlink
```

You could later run executable located in `build/image/bin`

[demo]: https://github.com/MysterionRise/kagan-figures/blob/master/src/main/resources/compare/DemoFullImage.png?raw=true "Demo"
[Jerome Kagan]:  http://en.wikipedia.org/wiki/Jerome_Kagan

