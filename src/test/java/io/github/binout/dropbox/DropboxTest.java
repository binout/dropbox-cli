package io.github.binout.dropbox;

import io.github.binout.dropbox.model.Folder;
import io.github.binout.dropbox.model.Path;

public class DropboxTest {

    // tag::feignMain[]
    public static void main(String[] args) {
        Dropbox.api()
                .listFolder(new Path(""))
                .stream()
                .map(Folder::getName)
                .forEach(System.out::println);
    }
    // end::feignMain[]
}