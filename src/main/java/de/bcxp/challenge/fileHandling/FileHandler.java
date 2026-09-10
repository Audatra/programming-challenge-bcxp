package de.bcxp.challenge.fileHandling;

import java.util.List;

public interface FileHandler<T>{

    List<T> getFileContents();
}
