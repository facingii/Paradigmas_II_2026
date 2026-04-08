package mx.uv.fiee.iinf.paradigmas.io;

import java.util.LinkedList;
import java.util.List;

public final class StudentFactory {
	private static final String[] NAMES = {
			"Ana López",
			"María, del Carmen",
			"Luis \"Lucho\" García",
			"Sofía Hernández",
			"José Martínez",
			"Elena Ruiz"
	};

	private static final String[] GROUPS = {
			"POO-A",
			"POO-B",
			"POO-C"
	};

	private static final String[] CITIES = {
			"Xalapa",
			"Veracruz",
			"Boca del Río",
			"Poza Rica",
			"Coatzacoalcos",
			"Veracruz, Centro"
	};

	private StudentFactory() {
	}

	public static List<Student> createStudents(int count) {
		if (count <= 0) {
			throw new IllegalArgumentException("The number of rows must be greater than zero.");
		}

		var students = new LinkedList<Student>();
		for (int index = 0; index < count; index++) {
			int id = 2026001 + index;
			String fullName = NAMES[index % NAMES.length];
			String groupName = GROUPS[index % GROUPS.length];
			String city = CITIES[index % CITIES.length];
			int age = 18 + (index % 6);
			double average = 7.4 + ((index * 0.35) % 2.4);
			boolean scholarship = index % 3 == 0;

			students.add(new Student(id, fullName, groupName, city, age, average, scholarship));
		}

		return students;
	}
}


