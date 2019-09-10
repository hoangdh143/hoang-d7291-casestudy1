package mitrais.view;

import mitrais.viewhandler.Dispatcher;

public interface View {
    void display();
    void setDispatcher(Dispatcher dispatcher);
    Dispatcher getDispatcher();
}
