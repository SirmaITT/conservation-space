package com.sirma.sep.cls;

import com.sirma.sep.cls.model.CodeList;
import com.sirma.sep.cls.model.CodeValue;

import java.util.List;

/**
 * Service for loading {@link CodeList} & {@link CodeValue}.
 * <p>
 * This service disallows modifications or the creation of new objects. For that use {@link com.sirma.itt.emf.cls.persister.SheetPersister}.
 *
 * @author Mihail Radkov
 */
public interface CodeListService {

	/**
	 * Fetches all available {@link CodeList} in the application.
	 * <p>
	 * This will not retrieve their {@link CodeValue}, for that use {@link #getCodeLists(boolean)}.
	 * <p>
	 * If no {@link CodeList} are available in the application then empty {@link List} will be returned.
	 *
	 * @return the available {@link CodeList}
	 */
	List<CodeList> getCodeLists();

	/**
	 * Fetches all available {@link CodeList} in the application.
	 * <p>
	 * This will retrieve their {@link CodeValue} if <code>true</code> is provided.
	 * <p>
	 * If no {@link CodeList} are available in the application then empty {@link List} will be returned.
	 *
	 * @param loadValues
	 * 		controls if the {@link CodeValue} for each {@link CodeList} will be loaded too
	 * @return the available {@link CodeList}
	 */
	List<CodeList> getCodeLists(boolean loadValues);

	/**
	 * Fetches all available {@link CodeValue} for specific parent {@link CodeList} value.
	 * <p>
	 * If there are no {@link CodeValue} for the specified {@link CodeList} value, then an empty {@link List} will be returned.
	 *
	 * @param codeListValue
	 * 		the value of the parent {@link CodeList}
	 * @return the available children {@link CodeValue} or empty {@link List} in case of missing values
	 */
	List<CodeValue> getCodeValues(String codeListValue);

}
