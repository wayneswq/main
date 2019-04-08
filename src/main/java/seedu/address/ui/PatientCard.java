package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import seedu.address.model.person.Patient;

/**
 * An UI component that displays information of a {@code Patient}.
 */
public class PatientCard extends UiPart<Region> {

    private static final String FXML = "PatientListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on DocX level 4</a>
     */

    public final Patient patient;

    @FXML
    private HBox cardPane;
    @FXML
    private Label id;
    @FXML
    private Label name;
    @FXML
    private Label pid;
    @FXML
    private Label gender;
    @FXML
    private Label age;
    @FXML
    private Label phone;
    @FXML
    private Label address;
    @FXML
    private FlowPane tags;
    @FXML
    private Label appointmentStatus;

    public PatientCard(Patient patient, int displayedIndex) {
        super(FXML);
        this.patient = patient;
        id.setText(displayedIndex + ". ");
        name.setText(patient.getName().fullName);
        pid.setText(patient.getIdToString());
        gender.setText(patient.getGender().value);
        age.setText(patient.getAge().value);
        phone.setText(patient.getPhone().value);
        address.setText(patient.getAddress().value);

        patient.getTags().forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));

        String appointmentStatusString = patient.getAppointmentStatus().toString();
        appointmentStatus.setText(appointmentStatusString);

        // does not work for now
        switch (appointmentStatusString) {
            case "CANCELLED": // red light
                this.appointmentStatus.setTextFill(Color.web("#F22613"));
                break;
            case "ACTIVE": // yellow light
                this.appointmentStatus.setTextFill(Color.web("#F7CA18"));
                break;
            case "COMPLETED": // green light
                this.appointmentStatus.setTextFill(Color.web("#00E640"));
                break;
            case "MISSED": // brown light
                this.appointmentStatus.setTextFill(Color.web("#A52A2A"));
                break;
            default:
                break;
        }
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PatientCard)) {
            return false;
        }

        // state check
        PatientCard card = (PatientCard) other;
        return id.getText().equals(card.id.getText())
                && patient.equals(card.patient);
    }
}
