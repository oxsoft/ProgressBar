# Steps to reproduce the problem
https://code.google.com/p/android/issues/detail?id=223871

Android 7.0, Nexus 9.

1. MainActivity has visible ProgressBar.
2. Start SecondActivity from the MainActivity.
3. Back to the MainActivity by tapping back key.
4. Then, SecondActivity's onStop() is not called immediately.
5. After 10 seconds, onStop() is called with following warning.

```
W/ActivityManager: Launch timeout has expired, giving up wake lock!
```

This problem does not happen if the ProgressBar is not visible.

And this problem does not happen on Android 6.0.1, Nexus 5.

## Another way to reproduce the problem

On Android 7.1.1, this problem still happens. ProgressBar is not the heart of problem.

Android 7.1.1, Emulator(x86)

1. MainActivity has a visible ProgressBar and **a rotating view**.
2. Start SecondActivity from the MainActivity.
3. Back to the MainActivity by tapping back key.
4. Then, SecondActivity's onStop() is not called immediately.
5. After 10 seconds, onStop() is called with following warning.

When all animations stopped, `SecondActivity#onStop()` is called immediatley.
