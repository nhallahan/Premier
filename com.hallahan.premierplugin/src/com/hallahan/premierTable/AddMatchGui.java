package com.hallahan.premierTable;


import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class AddMatchGui extends TitleAreaDialog {

  private Text txtHomeTeam;
  private Text txtAwayTeam;
  private String homeTeam;
  private String awayTeam;

  public AddMatchGui(Composite parentShell) {
    super((Shell)parentShell);
  }

  @Override
  public void create() {
    super.create();
    // Set the title
    setTitle("Enter team names");
    // Set the message
    setMessage("Enter team names", IMessageProvider.INFORMATION);

  }

  @Override
  protected Control createDialogArea(Composite parent) {
    Composite area = (Composite) super.createDialogArea(parent);
    Composite container = new Composite(area, SWT.NONE);
    container.setLayoutData(new GridData(GridData.FILL_BOTH));
    GridLayout layout = new GridLayout(2, false);
    container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    container.setLayout(layout);
    Label lbtHomeTeam = new Label(container, SWT.NONE);
    lbtHomeTeam.setText("Home Team :");

    GridData dataHomeTeam = new GridData();
    dataHomeTeam.grabExcessHorizontalSpace = true;
    dataHomeTeam.horizontalAlignment = GridData.FILL;

    txtHomeTeam = new Text(container, SWT.BORDER);
    txtHomeTeam.setLayoutData(dataHomeTeam);

    Label lbtLastName = new Label(container, SWT.NONE);
    lbtLastName.setText("Away team :");

    // You should not re-use GridData
    GridData dataLastName = new GridData();
    dataLastName.grabExcessHorizontalSpace = true;
    dataLastName.horizontalAlignment = GridData.FILL;
    txtAwayTeam = new Text(container, SWT.BORDER);
    txtAwayTeam.setLayoutData(dataLastName);
    return area;
  }

  @Override
  protected boolean isResizable() {
    return true;
  }

  // We need to save the values of the Text fields into Strings because the UI
  // gets disposed
  // and the Text fields are not accessible any more.
  private void saveInput() {
    homeTeam = txtHomeTeam.getText();
    awayTeam = txtAwayTeam.getText();

  }

  @Override
  protected void okPressed() {
    saveInput();
    super.okPressed();
  }

  public String getHomeTeam() {
    return homeTeam;
  }

  public String getAwayTeam() {
    return awayTeam;
  }
} 
