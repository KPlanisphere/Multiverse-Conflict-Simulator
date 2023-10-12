package com.mycompany.climaxdesenlacettpmt;

import java.util.concurrent.Semaphore;

class ClimaxDesenlaceTTPMT {
    public static void main(String[] args) {
        Semaphore semEvelyn = new Semaphore(1); // Semáforo para controlar a Evelyn
        Semaphore semWaymond = new Semaphore(0); // Semáforo para controlar a Waymond
        Semaphore semJobu = new Semaphore(0); // Semáforo para controlar a Jobu Tupaki
        Semaphore semMultiverso = new Semaphore(0); // Semáforo para el multiverso
        Semaphore semReparacion = new Semaphore(0); // Semáforo para las reparaciones

        Evelyn evelyn = new Evelyn(semEvelyn, semWaymond, semJobu, semMultiverso, semReparacion);
        Waymond waymond = new Waymond(semEvelyn, semWaymond, semJobu, semMultiverso, semReparacion);
        JobuTupaki jobu = new JobuTupaki(semEvelyn, semWaymond, semJobu, semMultiverso, semReparacion);
        Multiverso multiverso = new Multiverso(semEvelyn, semWaymond, semJobu, semMultiverso, semReparacion);
        Desenlace desenlace = new Desenlace(semEvelyn, semWaymond, semJobu, semMultiverso, semReparacion);

        Thread threadEvelyn = new Thread(evelyn);
        Thread threadWaymond = new Thread(waymond);
        Thread threadJobu = new Thread(jobu);
        Thread threadMultiverso = new Thread(multiverso);
        Thread threadDesenlace = new Thread(desenlace);

        threadEvelyn.start();
        threadWaymond.start();
        threadJobu.start();
        threadMultiverso.start();
        threadDesenlace.start();
    }
}

class Evelyn implements Runnable {
    private Semaphore semEvelyn;
    private Semaphore semWaymond;
    private Semaphore semJobu;
    private Semaphore semMultiverso;
    private Semaphore semReparacion;

    public Evelyn(Semaphore semEvelyn, Semaphore semWaymond, Semaphore semJobu, Semaphore semMultiverso, Semaphore semReparacion) {
        this.semEvelyn = semEvelyn;
        this.semWaymond = semWaymond;
        this.semJobu = semJobu;
        this.semMultiverso = semMultiverso;
        this.semReparacion = semReparacion;
    }

    public void run() {
        try {
            // Clímax
            System.out.println("Evelyn, Waymond, Joy y Gong Gong confrontan a Jobu Tupaki en su restaurante.");
            semEvelyn.acquire();
            semJobu.release(); //WAYMOND
            System.out.println("Evelyn vence a Jobu Tupaki con el poder del amor.");
            semMultiverso.release();
            semReparacion.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Waymond implements Runnable {
    private Semaphore semEvelyn;
    private Semaphore semWaymond;
    private Semaphore semJobu;
    private Semaphore semMultiverso;
    private Semaphore semReparacion;

    public Waymond(Semaphore semEvelyn, Semaphore semWaymond, Semaphore semJobu, Semaphore semMultiverso, Semaphore semReparacion) {
        this.semEvelyn = semEvelyn;
        this.semWaymond = semWaymond;
        this.semJobu = semJobu;
        this.semMultiverso = semMultiverso;
        this.semReparacion = semReparacion;
    }

    public void run() {
        // Clímax
        //semWaymond.acquire();
        System.out.println("Waymond revela a Evelyn que solo ella puede detener a Jobu Tupaki.");
        semJobu.release();
    }
}

class JobuTupaki implements Runnable {
    private Semaphore semEvelyn;
    private Semaphore semWaymond;
    private Semaphore semJobu;
    private Semaphore semMultiverso;
    private Semaphore semReparacion;

    public JobuTupaki(Semaphore semEvelyn, Semaphore semWaymond, Semaphore semJobu, Semaphore semMultiverso, Semaphore semReparacion) {
        this.semEvelyn = semEvelyn;
        this.semWaymond = semWaymond;
        this.semJobu = semJobu;
        this.semMultiverso = semMultiverso;
        this.semReparacion = semReparacion;
    }

    public void run() {
        // Clímax
        System.out.println("Jobu Tupaki amenaza con destruir el multiverso con una bola cósmica.");
        semWaymond.release();
        semEvelyn.release();
    }
}

class Multiverso implements Runnable {
    private Semaphore semEvelyn;
    private Semaphore semWaymond;
    private Semaphore semJobu;
    private Semaphore semMultiverso;
    private Semaphore semReparacion;

    public Multiverso(Semaphore semEvelyn, Semaphore semWaymond, Semaphore semJobu, Semaphore semMultiverso, Semaphore semReparacion) {
        this.semEvelyn = semEvelyn;
        this.semWaymond = semWaymond;
        this.semJobu = semJobu;
        this.semMultiverso = semMultiverso;
        this.semReparacion = semReparacion;
    }

    public void run() {
        try {
            // Clímax
            semMultiverso.acquire();
            System.out.println("El multiverso es salvado.");
            semEvelyn.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Desenlace implements Runnable {
    private Semaphore semEvelyn;
    private Semaphore semWaymond;
    private Semaphore semJobu;
    private Semaphore semMultiverso;
    private Semaphore semReparacion;

    public Desenlace(Semaphore semEvelyn, Semaphore semWaymond, Semaphore semJobu, Semaphore semMultiverso, Semaphore semReparacion) {
        this.semEvelyn = semEvelyn;
        this.semWaymond = semWaymond;
        this.semJobu = semJobu;
        this.semMultiverso = semMultiverso;
        this.semReparacion = semReparacion;
    }

    public void run() {
        try {
            // Desenlace
            semReparacion.acquire();
            System.out.println("Evelyn regresa a su universo siendo más feliz y realizada.");
            System.out.println("Evelyn repara su relación con su hija, Joy.");
            System.out.println("Evelyn se reconcilia con su padre, Gong Gong.");
            System.out.println("Evelyn abre una nueva lavandería con Waymond.");
            System.out.println("Evelyn continúa explorando el multiverso.");
            semEvelyn.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}