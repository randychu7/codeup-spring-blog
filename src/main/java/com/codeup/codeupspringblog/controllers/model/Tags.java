package com.codeup.codeupspringblog.controllers.model;

import java.util.HashSet;
import java.util.Set;

public class Tags {
    public static Set<Tag> makeTagSet(String tagsCsv){
        // create an empty set of tag objects to hold the tag objects
        Set<Tag> tagObjects = new HashSet<>();
        // if the user did not submit a tag, the tag input
        // returns an empty string. In this case we want
        // an empty set, so no tag is saved
        // otherwise it will save an empty string to the db
        if (tagsCsv.equals("")){
            return tagObjects;
        }
        //use .split to create an array of strings
        //from a comma separated list of tags and loop over it
        for (String tag : tagsCsv.split(",")){
            // trim each string and turn into a tag object
            Tag tagObject = new Tag(tag.trim());
            // add the objects to the set
            tagObjects.add(tagObject);
        }
        // return the set
        return tagObjects;
    }
}
