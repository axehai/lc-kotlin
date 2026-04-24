# lc-kotlin

Kotlin LeetCode practice repo. Focus only on `src/main/kotlin/lc/` and `src/test/kotlin/lc/`.

## Workflow

1. User gives a problem number (e.g. "LC 49") and optionally the category.
2. Claude looks up the problem, creates the solution stub + test file.
3. User implements the solution.
4. User submits when confident. Claude reviews only if asked.

## Directory layout

```
src/main/kotlin/lc/<category>/lc_<number>/LC<number>.kt      # solution stub
src/test/kotlin/lc/<category>/lc_<number>/LC<number>Test.kt  # tests
```

## Naming conventions

| Thing | Convention |
|---|---|
| Solution class | `LC<number>` (e.g. `LC49`) |
| Solution file | `LC<number>.kt` |
| Test class | `LC<number>Test` |
| Test file | `LC<number>Test.kt` |
| Solution package | `com.axehai.lc.<category>.lc_<number>` |
| Test package | `lc.<category>.lc_<number>` |

## Test structure

- `example1()`, `example2()` … — LC-provided examples
- `edge_<descriptiveName>()` — boundary/special cases (4–8 per problem)
- Use `assertEquals` for scalars, `assertContentEquals` for flat arrays, custom helpers for nested arrays
- Framework: `kotlin.test` with `@Test`, run via JUnit 5

## Solution stub shape

```kotlin
package com.axehai.lc.<category>.lc_<number>

class LC<number> {
    fun <methodName>(<params>): <returnType> {
        TODO()
    }
}
```
