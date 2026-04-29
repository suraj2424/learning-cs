# BACKEND

## API Design

#### What is Idempotency?

- In simpler terms, an operation is idempotent if executing it once has the same effect as executing it multiple times.

#### Have you ever handled Pagination/Filtering?

- Yes, i did in the academics.

#### How do you currently structure error responses in your APIs?

I do actually handled the error responses with the proper clean code and commenting as well as proper messages throughout the code.

### Corrections

**Idempotency**

- My idempotency definition is correct, but incomplete for backend reality:
    - It’s not just “same effect”
    - It’s about safe retries under failure (network, timeout, duplicate requests)

Example:
- POST /payment → NOT idempotent by default ❌
- But with idempotency key → becomes safe ✅

**Pagination/Filtering**

- I’ve “used it” but forgot internals → we’ll fix that properly (`this is critical in production`).

**Error Handling**

> “clean code + messages” is vague → in production, this means:

- consistent schema
- machine-readable + human-readable
- no leakage of internals

### Problem & Solutions

#### 1. Idempotency

**Problem:**

Client retries request due to timeout → server might process twice.

**Solution:**

- Use Idempotency Key
```http
POST /orders
Idempotency-Key: abc123
```
**Server**

- stores key + response
- if same key → return cached response

👉 Used in:

- payments
- order creation
- booking systems

#### 2. Pagination (Not just limit/offset)

**❌ Naive Approach:**

```sql
LIMIT 10 OFFSET 1000
```

**Problem:**

- slow for large data
- inconsistent if data changes

**Solution (production):**

*Cursor-based pagination*
```http
GET /posts?cursor=eyJpZCI6MTAwfQ==
```

- stable
- scalable
- no skipping/duplicates

#### 3. Filtering (Real Pattern)

```http
GET /products?category=books&price_lte=500&sort=price_desc
```

**Backend:**

- dynamic query building
- indexed fields only (**important**)

#### 4. API Error Structure

**Bad:**

```json
"Something went wrong"
```

**Good:**

```json
{
  "success": false,
  "error": {
    "code": "USER_NOT_FOUND",
    "message": "User does not exist",
    "details": null
  }
}
```

**Why?**

- frontend can act on `code`
- logs stay clean
- debugging becomes faster

