package com.example.unitconverter;

import com.example.unitconverter.coverters.BaseUnitConverter;
import com.example.unitconverter.coverters.UnitTypeConverter;
import com.example.unitconverter.coverters.length.LengthConverter;
import com.example.unitconverter.coverters.volume.VolumeConverter;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.util.StringConverter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Controller {
    @FXML
    private ComboBox<UnitTypeConverter> unitTypeMenu;
    @FXML
    private TextField leftTextField;
    @FXML
    private TextField rightTextField;
    @FXML
    private ComboBox<BaseUnitConverter> leftUnitMenu;
    @FXML
    private ComboBox<BaseUnitConverter> rightUnitMenu;

    private static UnitTypeConverter lengthConverter = new LengthConverter();
    private static UnitTypeConverter volumeConverter = new VolumeConverter();
    private List<UnitTypeConverter> allUnitTypeConverters = Arrays.asList(
            lengthConverter,
            volumeConverter);

    @FXML
    public void initialize() {
        unitTypeMenu.getItems().addAll(allUnitTypeConverters);
        unitTypeMenu.getSelectionModel().selectFirst();
        unitTypeMenu.setConverter(new StringConverter<UnitTypeConverter>() {
            @Override
            public String toString(UnitTypeConverter unitTypeConverter) {
                return unitTypeConverter.getUnitType();
            }

            @Override
            public UnitTypeConverter fromString(String s) {
                return null;
            }
        });

        List<BaseUnitConverter> baseUnitConverters =
                unitTypeMenu.getValue().getBaseUnitConvertersList();

        leftUnitMenu.getItems().addAll(baseUnitConverters);
        rightUnitMenu.getItems().addAll(baseUnitConverters);

        leftUnitMenu.getSelectionModel().select(0);
        rightUnitMenu.getSelectionModel().select(1);

        StringConverter<BaseUnitConverter> baseUnitStringConverter = new StringConverter<BaseUnitConverter>() {
            @Override
            public String toString(BaseUnitConverter baseUnitConverter) {
                return baseUnitConverter == null ? null : baseUnitConverter.getName();
            }

            @Override
            public BaseUnitConverter fromString(String s) {
                return null;
            }
        };

        leftUnitMenu.setConverter(baseUnitStringConverter);
        rightUnitMenu.setConverter(baseUnitStringConverter);

    }

    public void unitTypeChange(ActionEvent e) {
        ObservableList<BaseUnitConverter> newBaseConverters =
                FXCollections.observableArrayList(unitTypeMenu.getValue().getBaseUnitConvertersList());

        leftTextField.setText("");
        rightTextField.setText("");

        leftUnitMenu.setItems(newBaseConverters);
        rightUnitMenu.setItems(newBaseConverters);

        leftUnitMenu.getSelectionModel().select(0);
        rightUnitMenu.getSelectionModel().select(1);
    }

    public void leftUnitTypeChange(ActionEvent e) {
        convertRightToLeft();
    }

    public void rightUnitTypeChange(ActionEvent e) {
        convertLeftToRight();
    }

    public void leftTextFieldChange(KeyEvent e) {

        convertLeftToRight();
    }

    public void rightTextFieldChange(KeyEvent e) {

        convertRightToLeft();
    }

    private void convertLeftToRight() {
        if (leftTextField.getText().isBlank()) {
            rightTextField.setText("");
        }

        else {
            UnitTypeConverter unitTypeConverter = unitTypeMenu.getValue();
            BigDecimal leftUnit = new BigDecimal(Double.parseDouble(leftTextField.getText()));
            BigDecimal rightUnit = unitTypeConverter.convert(leftUnit,
                    leftUnitMenu.getValue(), rightUnitMenu.getValue());
            rightTextField.setText(rightUnit.stripTrailingZeros().toPlainString());
        }
    }

    private void convertRightToLeft() {
        if (rightTextField.getText().isBlank()) {
            leftTextField.setText("");
        }

        else {
            UnitTypeConverter unitTypeConverter = unitTypeMenu.getValue();
            BigDecimal rightUnit = new BigDecimal(Double.parseDouble(rightTextField.getText()));
            BigDecimal leftUnit = unitTypeConverter.convert(rightUnit,
                    rightUnitMenu.getValue(), leftUnitMenu.getValue());
            leftTextField.setText(leftUnit.stripTrailingZeros().toPlainString());
        }
    }
}