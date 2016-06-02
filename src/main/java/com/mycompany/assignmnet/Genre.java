/**
 *
 * @author Jonathan Borg and Karl Farrugia
 */
package com.mycompany.assignmnet;

//class used to create a Genre object
public class Genre {
    //all genres are strings
    String name;
    
    public Genre (String gen) {
        this.name = gen;
    }
    
    public String getGenre() {
        return name;
    }
}
