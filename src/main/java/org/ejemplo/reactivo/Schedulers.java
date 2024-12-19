package org.ejemplo.reactivo;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

class SchedulerExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Inicio del programa en hilo: " + Thread.currentThread().getName());

        Flux.range(1, 10)
                .map(i -> {
                    System.out.println("Procesando (map 1) el valor " + i + " en hilo: " + Thread.currentThread().getName());
                    return i * 2;
                })
                .publishOn(Schedulers.boundedElastic())
                .map(i -> {
                    System.out.println("Procesando (map 2) el valor " + i + " en hilo: " + Thread.currentThread().getName());
                    return i + 1;
                })
                .subscribeOn(Schedulers.parallel())
                .subscribe(i -> {
                    System.out.println("Recibiendo el valor " + i + " en hilo: " + Thread.currentThread().getName());
                });

        // Permitir que los hilos asíncronos terminen antes de que el programa finalice
        Thread.sleep(2000);
    }
}

/*
Tipos de Schedulers
Schedulers.parallel(): Adecuado para tareas computacionalmente intensivas.
Schedulers.boundedElastic(): Diseñado para tareas bloqueantes o de larga duración.
Schedulers.single(): Proporciona un solo hilo para ejecutar tareas secuencialmente.
Schedulers.immediate(): Ejecuta tareas en el hilo actual.
Schedulers.fromExecutor(): Permite personalizar el ejecutor (ExecutorService) para tareas específicas.

Aplicación práctica
Los Schedulers son útiles para controlar cómo y dónde se ejecutan las operaciones en pipelines reactivos,
especialmente en aplicaciones que necesitan aprovechar la concurrencia o realizar tareas bloqueantes
en hilos separados.


 */







