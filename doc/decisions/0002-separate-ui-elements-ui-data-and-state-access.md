---
status: accepted
date: 2026-09-04
---

# Separate UI elements, UI data, and State Access.

## Context and Problem Statement

It is a common occurrence to have UI components defined with domain specific language. This results in a 
proliferation of components that are visually similar. Furthermore, behavior and visualization become braided, making testing difficult.

State access is orthogonal to the UI and might be an obstacle for testing.

## Considered Options

* Separate nothing.
* Separate UI elements, UI data, and state access.
* Separate UI elements, keep UI data and state access together.

## Decision Outcome

Chosen option: "Separate UI elements, UI data, and state access", because testing is valued highly, proliferation of similar elements is a large cost, and state access is likely to be more work than merely dereferencing a single atom.

This will be implemented via two layers:

* Render: These functions take UI data in the form of plain values (e.g. maps) and transform them into hiccup. This layer is completely unaware of any domain language.
* Prepare: These functions take domain data in the form of plain values (e.g. maps) and transform them into UI data to be passed to render functions. These functions are dependent on the render functions and sometimes need to know the internal structure of render functions. Actions are constructed here.

The acquisition of data to be passed to Prepare and the composition of Prepare and Render happens elsewhere.
