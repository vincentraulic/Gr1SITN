ALTER TABLE task
ADD mandayUsed INT NOT NULL
DEFAULT 0;

ALTER TABLE event
ADD type ENUM('ABSENCE',
	'LEAVE',
	'SICK_LEAVE',
	'FORMATION',
	'PROJECT_ENTRY',
	'PROJECT_EXIT',
	'MEETING',
	'OTHER')
;