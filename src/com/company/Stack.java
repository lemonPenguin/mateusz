package com.company;

import sample.Node;

public interface Stack {
    Node pop();
    void push(Node node);
    boolean isEmpty();
    int size();

}