package com.company;

import org.junit.jupiter.api.Test;

import java.awt.image.renderable.ContextualRenderedImageFactory;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void indkomst2() {
        Controller c = new Controller();
       int re =  c.indkomst2();
       assertEquals(4800,re);
    }
}