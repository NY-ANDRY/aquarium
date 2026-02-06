export const formatDateFr = (str) => {
  return new Date(str).toLocaleDateString("fr-FR", {
    day: "2-digit",
    month: "short",
    year: "numeric",
  });
};

export const datePicktoDate = (datePickerValue) => {
  const y = datePickerValue.getFullYear();
  const m = String(datePickerValue.getMonth() + 1).padStart(2, "0");
  const d = String(datePickerValue.getDate()).padStart(2, "0");

  return `${y}-${m}-${d}`;
};
