package menu.manager;

import org.eclipse.jface.action.Action; 
import org.eclipse.jface.action.MenuManager; 
import org.eclipse.jface.action.ToolBarManager; 
import org.eclipse.swt.SWT; 
import org.eclipse.swt.layout.FillLayout; 
import org.eclipse.swt.widgets.Display; 
import org.eclipse.swt.widgets.Shell; 
import org.eclipse.swt.widgets.ToolBar; 
 // http://hexapixel.com/2009/05/22/menumanagers-and-you
public class MenuManagerTest1 { 
 
    public MenuManagerTest1() { 
        Display display = new Display(); 
        Shell shell = new Shell(display, SWT.SHELL_TRIM); 
        shell.setLayout(new FillLayout()); 
 
        ToolBarManager tbm = new ToolBarManager(SWT.FLAT | SWT.RIGHT); 
        tbm.add(new OneAction()); 
        ToolBar tb = tbm.createControl(shell); 
 
        MenuManager mm = new MenuManager("Test Menu"); 
        mm.add(new OneAction()); 
        mm.add(new OneAction("Айтем 2")); 
        tbm.setContextMenuManager(mm); 
 
        // dispose shell, this will dispose all sub-widgets as well 
        //shell.dispose(); 
         
        // check status of our stuff 
        System.out.println("Toolbar is disposed? - " + tb.isDisposed()); 
        System.out.println("Menu is disposed? - " + mm.getMenu().isDisposed()); 
        System.out.println("ToolbarManager contains what? " + tbm.getItems()); 
        System.out.println("MenuManager contains what? " + mm.getItems()); 
        
        
        shell.pack();
		shell.open();
		//textUser.forceFocus();

		// Set up the event loop.
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				// If no more entries in event queue
				display.sleep();
			}
		}

		display.dispose();
    } 
 
    class OneAction extends Action { 
        public OneAction() { 
            super("Test Action"); 
        } 
 
        public OneAction(String string) {
        	super(string);
        }

		@Override 
        public void run() { 
            System.out.println("Action was run"); 
        }      
    } 
 
    public static void main(String[] args) { 
        new MenuManagerTest1(); 
    } 
 
}  