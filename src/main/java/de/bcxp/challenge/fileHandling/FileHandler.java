package de.bcxp.challenge.fileHandling;

import java.util.List;

/**
 * Handle the reading of files by returning the file contents as a list of Objects with type T
 */
public interface FileHandler<T>{

    List<T> getFileContents();
}
