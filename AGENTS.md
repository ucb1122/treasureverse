# Treasureverse Agent Rules

## Product Direction

Treasureverse is a social showcase platform where users upload photos, write posts, build profiles, and interact through comments, likes, and follows.

Treasureverse is not a marketplace. Do not implement sales, auctions, bidding, orders, payments, shipping, escrow, seller dashboards, buyer flows, or product checkout features.

## Stack

- Java 21
- Spring Boot 4.0.7
- Gradle
- Spring Data JPA
- MySQL
- MinIO for local S3-compatible image storage
- Spring Security later

## Package Rules

Package code by domain:

- member
- auth
- profile
- post
- comment
- like
- follow
- storage

Each domain may contain subpackages such as:

- controller
- service
- repository
- domain
- dto

## Coding Rules

- Controllers must not contain business logic.
- Services handle application logic.
- Entities must not be returned directly from controllers.
- Use request and response DTOs for APIs.
- Use constructor injection.
- Do not use field injection.
- Do not commit credentials, secrets, tokens, or local environment values.
- Add tests for important business logic.
- Keep changes scoped to the assigned issue.

## Security And Auth Direction

- Design member data so email/password login and OAuth login can coexist.
- Passwords must never be stored in plain text.
- OAuth accounts should be modeled separately from members.
- Authorization decisions should be explicit and testable.

## Storage Direction

- Use the `storage` domain for file upload behavior.
- Do not call MinIO directly from post, profile, or member services.
- Keep storage behind an application-level abstraction so MinIO can be replaced with AWS S3 later.
- Do not commit real MinIO credentials or production bucket names.
- Local development may use `minioadmin` credentials only through environment defaults or `.env` files.

## Git Rules

Branch format:

```text
feat/{issue-number}-{short-description}
fix/{issue-number}-{short-description}
chore/{issue-number}-{short-description}
```

Commit format:

```text
feat: short description #{issue-number}
fix: short description #{issue-number}
chore: short description #{issue-number}
```

Pull requests should include:

- Summary
- Tests run
- Linked issue

Codex workflow rules:

- Do not create Gradle cache directories inside the project, such as `.gradle-codex`.
- Keep implementation changes small and scoped before running heavier verification.
- If the default user Gradle cache is unavailable, do not force tests by writing caches into the repository. Run tests only after an approved cache location is available, or clearly report that tests were not run.
- Check `git status --short` during work, especially after dependency downloads or test attempts, to catch accidental generated files early.
