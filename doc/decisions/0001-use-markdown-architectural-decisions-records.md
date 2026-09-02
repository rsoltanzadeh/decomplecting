---
status: accepted
date: 2026-09-02
---

# Use Markdown Architectural Decision Records.

## Context and Problem Statement

This core value of this project is simplicity and quality. Hence, architectural decisions (ADs) will be made
carefully and strictly adhered to. These decisions are, however, not trivial to deduce from reading the code
and easy to forget. The reasoning behind a decision is often not obvious (simple is often hard). Decisions have—despite the youth of this project—already been forgotten and repeated several times. This results in time lost, lack of flow, and frustration.

## Considered Options

* Do not document ADs.
* Document ADs in a single file.
* Use Michael Nygard's ADR template.
* Use MADR 4.0.0.

## Decision Outcome

Chosen option: "Use MADR 4.0.0", because

* The cost of not documenting ADs is too high.
* ADs are important enough to be documented separately and rigorously.
* MADR is developed carefully, renders beautifully due to frontmatter, and is comprehensive without being overly verbose.
