import React from "react";
import Contact from "./Contact";

const ContactList = ({ data, currentPage, getAllContacts }) => {
  return (
    <main className="main">
      {data?.content?.length === 0 && (
        <div>No Contacts. Please add new contact</div>
      )}

      <ul className="contact__list">
        {data?.content?.length > 0 &&
          data.content.map((contact) => (
            <Contact contact={contact} key={contact.id} />
          ))}
      </ul>
      {data?.content?.length > 0 && data?.totalPages > 1 && (
        <div className="pagination">
          <a
            className={0 === currentPage ? "disabled" : ""}
            onClick={() => getAllContacts(currentPage - 1)}
          >
            &laquo;
          </a>
          {data &&
            [...Array(data.totalPages).keys()].map((page, index) => {
              <a
                onClick={() =>getAllContacts(page)}
                className={currentPage === page ? "active" : ""}
                key={page}
              >
                {" "}
                {page + 1}
              </a>;
            })}
          <a
            className={data.totalPages === currentPage + 1 ? "disabled" : ""}
            onClick={() => getAllContacts(currentPage + 1)}
          >
            {" "}
            &raquo;
          </a>
        </div>
      )}
    </main>
  );
};

export default ContactList;
