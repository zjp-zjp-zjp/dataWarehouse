package com.example.datawarehouse.entity;

public class Movie {
    private String MediaFormat;
    private String Producers;
    private String Writers;
    private String ASIN;
    private String imdbRating;
    private String Numberofdiscs;
    private String type;
    private String title;
    private String Studio;
    private String MPAArating;
    private String Runtime;
    private String customer_rating;
    private String pages;
    private String Language;
    private String  PackageDimensions;
    private String Subtitles;
    private String  IsDiscontinuedByManufacturer;
    private String Director;
    private String Actors;
    private String AspectRatio;
    private String ProductDimensions;
    private String  Itemmodelnumber;
    private String  Dubbed;
    private String  Releasedate;

    public Movie() {
    }

    public Movie(String mediaFormat, String producers, String writers, String ASIN, String imdbRating, String numberofdiscs, String type, String title, String studio, String MPAArating, String runtime, String customer_rating, String pages, String language, String packageDimensions, String subtitles, String isDiscontinuedByManufacturer, String director, String actors, String aspectRatio, String productDimensions, String itemmodelnumber, String dubbed, String releasedate) {
        MediaFormat = mediaFormat;
        Producers = producers;
        Writers = writers;
        this.ASIN = ASIN;
        this.imdbRating = imdbRating;
        Numberofdiscs = numberofdiscs;
        this.type = type;
        this.title = title;
        Studio = studio;
        this.MPAArating = MPAArating;
        Runtime = runtime;
        this.customer_rating = customer_rating;
        this.pages = pages;
        Language = language;
        PackageDimensions = packageDimensions;
        Subtitles = subtitles;
        IsDiscontinuedByManufacturer = isDiscontinuedByManufacturer;
        Director = director;
        Actors = actors;
        AspectRatio = aspectRatio;
        ProductDimensions = productDimensions;
        Itemmodelnumber = itemmodelnumber;
        Dubbed = dubbed;
        Releasedate = releasedate;
    }

    public String getMediaFormat() {
        return MediaFormat;
    }

    public void setMediaFormat(String mediaFormat) {
        MediaFormat = mediaFormat;
    }

    public String getProducers() {
        return Producers;
    }

    public void setProducers(String producers) {
        Producers = producers;
    }

    public String getWriters() {
        return Writers;
    }

    public void setWriters(String writers) {
        Writers = writers;
    }

    public String getASIN() {
        return ASIN;
    }

    public void setASIN(String ASIN) {
        this.ASIN = ASIN;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getNumberofdiscs() {
        return Numberofdiscs;
    }

    public void setNumberofdiscs(String numberofdiscs) {
        Numberofdiscs = numberofdiscs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStudio() {
        return Studio;
    }

    public void setStudio(String studio) {
        Studio = studio;
    }

    public String getMPAArating() {
        return MPAArating;
    }

    public void setMPAArating(String MPAArating) {
        this.MPAArating = MPAArating;
    }

    public String getRuntime() {
        return Runtime;
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
    }

    public String getCustomer_rating() {
        return customer_rating;
    }

    public void setCustomer_rating(String customer_rating) {
        this.customer_rating = customer_rating;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getPackageDimensions() {
        return PackageDimensions;
    }

    public void setPackageDimensions(String packageDimensions) {
        PackageDimensions = packageDimensions;
    }

    public String getSubtitles() {
        return Subtitles;
    }

    public void setSubtitles(String subtitles) {
        Subtitles = subtitles;
    }

    public String getIsDiscontinuedByManufacturer() {
        return IsDiscontinuedByManufacturer;
    }

    public void setIsDiscontinuedByManufacturer(String isDiscontinuedByManufacturer) {
        IsDiscontinuedByManufacturer = isDiscontinuedByManufacturer;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getActors() {
        return Actors;
    }

    public void setActors(String actors) {
        Actors = actors;
    }

    public String getAspectRatio() {
        return AspectRatio;
    }

    public void setAspectRatio(String aspectRatio) {
        AspectRatio = aspectRatio;
    }

    public String getProductDimensions() {
        return ProductDimensions;
    }

    public void setProductDimensions(String productDimensions) {
        ProductDimensions = productDimensions;
    }

    public String getItemmodelnumber() {
        return Itemmodelnumber;
    }

    public void setItemmodelnumber(String itemmodelnumber) {
        Itemmodelnumber = itemmodelnumber;
    }

    public String getDubbed() {
        return Dubbed;
    }

    public void setDubbed(String dubbed) {
        Dubbed = dubbed;
    }

    public String getReleasedate() {
        return Releasedate;
    }

    public void setReleasedate(String releasedate) {
        Releasedate = releasedate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "MediaFormat='" + MediaFormat + '\'' +
                ", Producers='" + Producers + '\'' +
                ", Writers='" + Writers + '\'' +
                ", ASIN='" + ASIN + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                ", Numberofdiscs='" + Numberofdiscs + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", Studio='" + Studio + '\'' +
                ", MPAArating='" + MPAArating + '\'' +
                ", Runtime='" + Runtime + '\'' +
                ", customer_rating='" + customer_rating + '\'' +
                ", pages='" + pages + '\'' +
                ", Language='" + Language + '\'' +
                ", PackageDimensions='" + PackageDimensions + '\'' +
                ", Subtitles='" + Subtitles + '\'' +
                ", IsDiscontinuedByManufacturer='" + IsDiscontinuedByManufacturer + '\'' +
                ", Director='" + Director + '\'' +
                ", Actors='" + Actors + '\'' +
                ", AspectRatio='" + AspectRatio + '\'' +
                ", ProductDimensions='" + ProductDimensions + '\'' +
                ", Itemmodelnumber='" + Itemmodelnumber + '\'' +
                ", Dubbed='" + Dubbed + '\'' +
                ", Releasedate='" + Releasedate + '\'' +
                '}';
    }
}
