# Structured Concurrency Exercise

This kata is designed to teach three ideas in order:

1. Run sibling coroutines concurrently with `coroutineScope` and `async`.
2. See fail-fast behavior in regular structured concurrency.
3. See how `supervisorScope` changes sibling failure behavior.

Work in [StructuredConcurrencyExercise.kt](/Users/axehai/Desktop/codebase/lc-kotlin/src/main/kotlin/playground/StructuredConcurrencyExercise.kt).

The tests are in [StructuredConcurrencyExerciseTest.kt](/Users/axehai/Desktop/codebase/lc-kotlin/src/test/kotlin/playground/StructuredConcurrencyExerciseTest.kt).

Recommended workflow:

1. Run only the new test class.
2. Make `prepareLunch` pass first.
3. Then make `prepareLunchFailFast` pass.
4. Then make `prepareLunchSupervised` pass.

What each test is teaching:

- `prepareLunch_runsRiceAndChickenConcurrently`
  The total virtual time should be `1500`, not `2500`.
- `prepareLunchFailFast_cancelsRiceWhenChickenFails`
  A child failure should cancel its sibling in a regular `coroutineScope`.
- `prepareLunchSupervised_allowsRiceToFinishWhenChickenFails`
  In a `supervisorScope`, one child can fail without canceling its sibling.

Suggested APIs to reach for:

- `coroutineScope`
- `supervisorScope`
- `async`
- `await`
- `try/catch`

Constraint:

- Do not use `GlobalScope`.
- Do not create ad hoc unmanaged scopes with `CoroutineScope(...)` inside the exercise methods.
