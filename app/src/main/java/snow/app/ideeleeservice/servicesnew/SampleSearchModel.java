package snow.app.ideeleeservice.servicesnew;

import ir.mirrajabi.searchdialog.core.Searchable;

public class SampleSearchModel implements Searchable {
    private String mTitle;

    public SampleSearchModel(String title) {
        mTitle = title;
    }

    @Override
    public String getTitle() {
        return mTitle;
    }

    public SampleSearchModel setTitle(String title) {
        mTitle = title;
        return this;
    }
}
