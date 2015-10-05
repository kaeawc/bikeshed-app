# Bikeshed App

This is just a collection of ideas about how to build a decoupled Android app. As I iterate on this repo the goal is to keep build everything fast, incremental, parallel, decoupled, and highly testable.

## Fast

There is an experimental product flavor called `fast` that raises the minimum Android SDK to 21. The hope is that this removes the need to compile in support for older versions.

## Incremental

Gradle has experimental support for incremental builds in its dexOptions. I've passed this parameter into the main app and each library.

## Parallel

Gradle has default support for parallel builds. No effort required.

## Decoupled

In order to be decoupled, modules cannot be chained together. Right now that is not the case because the chain goes `app` > `ui` > `network` > `data` > `core`.

I'll have to think about this a bit more and decide how to split up the modules in a better way.

## Testable

To be testable requires that there be no static singletons, because that would require PowerMock to properly test.


