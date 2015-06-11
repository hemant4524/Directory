package com.hemant.directory.vo;

import java.util.List;
 
public class Curator {
    public String title;
    public List<Dataset> dataset;

    public class Dataset {
        String curator_title;
        String curator_tagline;
    }
}
