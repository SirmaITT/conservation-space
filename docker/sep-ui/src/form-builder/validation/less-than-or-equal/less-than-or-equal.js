import {Injectable} from 'app/app';
import {FieldValidator} from 'form-builder/validation/field-validator';

/**
 * Validate that a value is less or equal than provided expected value.
 *
 * @author svelikov
 */
@Injectable()
export class LessThanOrEqual extends FieldValidator {

  validate(fieldName, validatorDef, validationModel) {
    let isValid = false;
    let viewValue = this.getViewValueAsNumber(fieldName, validationModel);
    if(viewValue) {
      isValid = viewValue <= validatorDef.context.value;
    }
    return isValid;
  }

}