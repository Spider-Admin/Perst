# Perst

Perst is a pure Java/.NET/Mono object-oriented embedded database system. Objectoriented here means that Perst is able to store/load objects directly. Embedded means Perst is intended to be included inside an application that needs its own data storage.

Perst’s goal is to provide programmers with a convenient and powerful mechanism to deal with large volumes of data. Several fundamental assumptions determine Perst’s design:

1. Persistent objects should be accessed in almost the same way as transient objects.
2. A database engine should be able to efficiently manage much more data than can fit in main memory.
3. No specialized preprocessors, enhancers, compilers, virtual machines or other tools should be required to use the database and to develop applications using it.

## Information about this repository

McObject provided two versions of Perst:

- a [repository](https://github.com/mcobject/perst), which uses the new package name `com.mcobject.perst`
- a [zip file](https://www.mcobject.com/perst/), which uses the old package name `org.garret.perst`

The version from the repository can read and write database files created with both versions of Perst but the version from the zip file can only read and write database files created with the version from the zip file.

Due this situation the repository is the best way to use Perst for new applications, while the zip archive is the best version for old applications who wants to stay compatible with older versions.

To easily include the version from zip file as dependency, I (Spider-Admin) created this repository. The following files and folders were created by McObject:

- `doc` folder
- `src` folder
- file `CHANGES`
- file `license.html`

Furthermore I reused description, license and contact from `doc/tutorial.pdf` in this README.

## Requirements

- Java 8 or newer.

## Build

You can manually build Perst to get a jar file, which you can add as dependency or you can use [JitPack](https://jitpack.io/) to include Perst as dependency using Gradle.

### Manual build

1. Download the source code and extract it.
2. Open a command prompt in the root directory of the extracted source code.
3. Run the following command: `gradlew build`. This will create a jar file in `build/libs`.

### JitPack

Add these lines to your `build.gradle`:

```
repositories {
  maven {
    url "https://jitpack.io"
  }
}

dependencies {
  implementation("com.github.Spider-Admin:Perst:v4.40.0")
}
```

## License

© Copyright McObject LLC

Perst is open source: you can redistribute it and/or modify it under the terms of version 3 (or earlier versions) of the GNU General Public License as published by the Free Software Foundation.

If you are unable to comply with the GPL, a commercial license for this software may be purchased from McObject LLC.

## Contact

McObject LLC  
22525 SE 64th Place, Suite 302  
Issaquah, WA 98027 USA  
Phone: 425-888-8505  
Fax: 425-888-8508  
E-mail: [info@mcobject.com](mailto:info@mcobject.com)  
[www.mcobject.com](https://www.mcobject.com/)  
