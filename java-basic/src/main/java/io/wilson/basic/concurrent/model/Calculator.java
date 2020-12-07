package io.wilson.basic.concurrent.model;

import lombok.Data;

/**
 * @author Wilson
 */
@Data
public class Calculator {
    private Plus plus = new Plus();

}
